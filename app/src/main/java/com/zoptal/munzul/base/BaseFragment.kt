package com.zoptal.munzul.base


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import dagger.android.support.AndroidSupportInjection



abstract class BaseFragment<VB: ViewDataBinding> : Fragment() {
    var baseView: View? = null
    lateinit var binding:VB



    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
    var rootView: View? = null

    override fun onResume() {
        super.onResume()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, getFragment(), container, false)
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        rootView = binding.root


        return rootView
    }

    fun getPersistentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
        layout: Int
    ): View? {
        if (rootView == null) {
            // Inflate the layout for this fragment using DataBindingUtil
            binding = DataBindingUtil.inflate(inflater!!, layout, container, false)
            rootView = binding.root
        } else {
            // Do not inflate the layout again.
            // The returned View of onCreateView will be added into the fragment.
            // However it is not allowed to be added twice even if the parent is same.
            // So we must remove rootView from the existing parent view group
            // (it will be added back).
            (rootView?.parent as? ViewGroup)?.removeView(rootView)
        }

        return rootView
    }
    fun setTitle(title: String) {
        (activity as BaseActivity).setTitle(title)
    }

    fun popBackStack() {
        (activity as BaseActivity).popBackStack()
    }





    //abstract function for binding layout
    abstract fun getFragment(): Int


    // To navigate the current fragment to Desination Safe
    fun NavController.safeNavigate(direction: NavDirections) {
        Log.d("DATA", "Click happened")
        currentDestination?.getAction(direction.actionId)?.run {
            Log.d("DATA", "Click Propagated")
            navigate(direction)
        }
    }

//    /**
//     * This method will cache the data locally
//     */
//    fun cachePutSignUpData(info: VerifyOTPResponse) {
//        val gson = Gson()
//        val responsInfos = gson.toJson(info)
//        Preferences.prefs?.saveValue(CacheConstants.USER_RESPONCE, responsInfos)
//    }
//
//    /**
//     * This method will get user respoonce data from local
//     */
//    fun getUserSignUpData(): VerifyOTPResponse? {
//        val info = Preferences.prefs?.getValue(CacheConstants.USER_RESPONCE, "")
//        if (info?.length ?: 0 > 0) {
//            mRegisterData = Gson().fromJson(info, VerifyOTPResponse::class.java)
//        }
//        return mRegisterData
//    }
//
//
//    /**
//     * This method will get user Name from local
//     */
//    fun getUserName(): String? {
//        var userName: String? = null
//        userName =
//            if (getUserSignUpData()?.results != null && !(getUserSignUpData()?.results?.equals("")!!)) {
//                getUserSignUpData()?.results?.userName
//            } else {
//                getUserSignUpData()?.results!!.userName
//            }
//        return userName
//    }
//
//    /**
//     * This method will get PhoneNumber from local
//     */
//    fun getPhoneNum(): String? {
//        var phoneNum: String? = null
//        phoneNum =
//            if (getUserSignUpData()?.results != null && !(getUserSignUpData()?.results?.equals("")!!)) {
//                getUserSignUpData()?.results?.contact
//            } else {
//                getUserSignUpData()?.results!!.contact
//            }
//        return phoneNum
//    }
///**
//     * This method will get Profile from local
//     */
//    fun getProfilePic(): String? {
//        var phoneNum: String? = null
//        phoneNum =
//            if (getUserSignUpData()?.results != null && !(getUserSignUpData()?.results?.equals("")!!)) {
//                getUserSignUpData()?.results?.profile_photo
//            } else {
//                getUserSignUpData()?.results!!.profile_photo
//            }
//        return phoneNum
//    }
//
//    /**
//     * This method will get CountryCode from local
//     */
//    fun getCountryCodeLocal(): String? {
//        var countryCodelocal: String? = null
//        countryCodelocal =
//            if (getUserSignUpData()?.results != null && !(getUserSignUpData()?.results?.equals("")!!)) {
//                getUserSignUpData()?.results?.countryCode
//            } else {
//                getUserSignUpData()?.results!!.countryCode
//            }
//        return countryCodelocal
//    }
//    /**
//     * This method will get user Email from local
//     */
//    fun getUserEmail(): String? {
//        var userEmail: String? = null
//        userEmail =
//            if (getUserSignUpData()?.results != null && !(getUserSignUpData()?.results?.equals("")!!)) {
//                getUserSignUpData()?.results?.email
//            } else {
//                getUserSignUpData()?.results!!.email
//            }
//        return userEmail
//    }
//
//
//    /**
//     * This method will get user Email Verification Status from local
//     */
//    fun getEmailVerified(): Boolean? {
//        var userEmail: Boolean? = null
//        userEmail =
//            if (getUserSignUpData()?.results != null && !(getUserSignUpData()?.results?.equals("")!!)) {
//                getUserSignUpData()?.results?.isEmailVerified
//            } else {
//                getUserSignUpData()?.results!!.isEmailVerified
//            }
//        return userEmail
//    }
//   /**
//     * This method will get user Phone Verification Status from local
//     */
//    fun getPhoneVerified(): Boolean? {
//        var userPhone: Boolean? = null
//       userPhone =
//            if (getUserSignUpData()?.results != null && !(getUserSignUpData()?.results?.equals("")!!)) {
//                getUserSignUpData()?.results?.isPhoneNumberVerified
//            } else {
//                getUserSignUpData()?.results!!.isPhoneNumberVerified
//            }
//        return userPhone
//    }
// /**
//     * This method will get user UserId from local
//     */
//    fun getUserID(): String? {
//        var userID: String? = null
//     userID =
//            if (getUserSignUpData()?.results != null && !(getUserSignUpData()?.results?.equals("")!!)) {
//                getUserSignUpData()?.results?._id
//
//            } else {
//                getUserSignUpData()?.results!!._id
//            }
//        return userID
//    }
//
//    /**
//     * This method will get user AccessToken from local
//     */
//    fun getAccessToken(): String? {
//        var accessToken: String? = ""
//        accessToken =
//            if (getUserSignUpData()?.results != null && !(getUserSignUpData()?.results?.equals("")!!)) {
//                getUserSignUpData()?.results?.accessToken
//            } else {
//                getUserSignUpData()?.results!!.accessToken
//            }
//        return accessToken
//    }
//    /**
//     * This method will get user Is Social Login or nOt from local
//     */
//    fun getIsSocial(): Boolean? {
//        var isSocial: Boolean? = false
//        isSocial =
//            if (getUserSignUpData()?.results != null && !(getUserSignUpData()?.results?.equals("")!!)) {
//                getUserSignUpData()?.results?.isSocial
//            } else {
//                getUserSignUpData()?.results!!.isSocial
//            }
//        return isSocial
//    }
}


