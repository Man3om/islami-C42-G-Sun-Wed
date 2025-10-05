package com.route.islamic42gsunwed.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islamic42gsunwed.databinding.FragmentQuranBinding
import com.route.islamic42gsunwed.databinding.FragmentRadioBinding
import com.route.islamic42gsunwed.fragments.radio.RadioAdapter
import com.route.islamic42gsunwed.fragments.radio.api.RadioApi
import com.route.islamic42gsunwed.fragments.radio.api.model.RadioResponse
import com.route.islamic42gsunwed.fragments.radio.api.model.RadiosItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadioFragment : Fragment() {
    private lateinit var binding: FragmentRadioBinding

    private lateinit var radios : List<RadiosItem>
    private lateinit var adapter: RadioAdapter // Initialize the adapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null)
            getRadios()

        binding.radioRecyclerView.adapter = adapter
        adapter = RadioAdapter(radios)
    }

    private fun getRadios() {
        RadioApi.getRadioServices().getRadios().enqueue(object : Callback<RadioResponse> {
            override fun onResponse(
                call: Call<RadioResponse?>,
                response: Response<RadioResponse?>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("data", data.toString())
                    radios = data?.radios?: emptyList()
                }
            }

            override fun onFailure(
                call: Call<RadioResponse?>,
                t: Throwable
            ) {
                Log.e("error", t.message.toString())
            }

        })
    }

}
