package com.example.splitwise

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splitwise.room_database_files.*
import kotlinx.android.synthetic.main.fragment_friends_.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class Friends_Fragment : Fragment(),RecyclerClickListener {
    private var userList = emptyList<User>()
    private lateinit var userListAdapter: UserListAdapter
    private lateinit var userListViewModel: UserListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_friends_, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Friends_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAddMOreFriends.setOnClickListener{
            val intent = Intent(context, Add_Friends_to_Database_Activity::class.java)
            startActivity(intent)

        }
        btnCircleIconToAdd.setOnClickListener{
            val intent_1=Intent(context,AddIconActivity::class.java)
            startActivity(intent_1)
        }
        userListViewModel = getContext()?.let { UserListViewModelFactory(it).create(UserListViewModel::class.java) }!!
        userListViewModel.fetchDataFromDB().observe(this, {
            it?.let {
                this.userList = it
                userListAdapter.updateData(userList)
            }
        })
        setRecyclerAdapter()
    }

    private fun setRecyclerAdapter() {
        userListAdapter = UserListAdapter(userList, this)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerViewFriendsFragment.layoutManager = linearLayoutManager
        recyclerViewFriendsFragment.adapter = userListAdapter

    }

    override fun onItemCLicked(position: Int, user: User) {
//launch a activity or a fragment


    }
}