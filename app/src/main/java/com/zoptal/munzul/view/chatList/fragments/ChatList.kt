package com.zoptal.munzul.view.chatList.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zoptal.munzul.databinding.ChatListingBinding
import com.zoptal.munzul.view.chatList.adapters.ChatListAdapter

class ChatList: Fragment() {


    lateinit var sContext: Activity
    private lateinit var binding: ChatListingBinding
    lateinit var chatListAdapter: ChatListAdapter
    private var chatListList = ArrayList<String>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ChatListingBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * On View Created
     * */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapters()
        sContext = requireActivity()
        clickHandler()

    }

    /**
     * Set Adapters
     * */
    private fun setAdapters(){
        chatListList.add("")
        chatListList.add("")
        chatListList.add("")
        chatListAdapter = ChatListAdapter(requireActivity(), chatListList)
        binding.rvChatListing.adapter = chatListAdapter
    }

    /**
     * Click Handler
     * */
    private fun clickHandler() {
        binding.etLocation.setOnClickListener {
//            findNavController().navigate(R.id.action_introFragment_to_splash)
        }
    }
}