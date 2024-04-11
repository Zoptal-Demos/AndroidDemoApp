package com.zoptal.munzul.view.authentication.adapters

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.zoptal.munzul.R
import com.zoptal.munzul.databinding.AppIntroItemBinding
import com.zoptal.munzul.model.IntroData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class IntroAdapter internal constructor(sContext: Activity, arrayList: List<IntroData>) :
    PagerAdapter() {
    var sContext: Context
    var arrayList: List<IntroData>
    var layoutInflater: LayoutInflater
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View = layoutInflater.inflate(R.layout.app_intro_item, container, false)
        container.addView(itemView)
        val ivIntro: ImageView = itemView.findViewById(R.id.ivIntro);
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle);
        val tvSubTitle: TextView = itemView.findViewById(R.id.tvSubTitle);
        tvTitle.text =arrayList[position].title
        tvSubTitle.text= arrayList[position].subTitle
        Glide.with(sContext).load(arrayList[position].image)
            .placeholder(R.drawable.onboarding_1).into(ivIntro)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

    init {
        this.sContext = sContext
        this.arrayList = arrayList
        layoutInflater =
            sContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}