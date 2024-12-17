package com.example.finaluirs.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.finaluirs.R
import com.example.finaluirs.adapters.ImageSliderAdapter
import com.example.finaluirs.adapters.PopularAdapter
import com.example.finaluirs.models.PopularModel
import com.example.finaluirs.models.UserViewModel


class HomeFragment : Fragment() {

    private lateinit var homeviewPager2: ViewPager2
    private lateinit var homeadapter: ImageSliderAdapter
    private lateinit var homeimageList: ArrayList<Int>
    private lateinit var homehandler: Handler

    private lateinit var popularAdapter: PopularAdapter
    private lateinit var listPopular: ArrayList<PopularModel>
    private lateinit var homeRecycleView: RecyclerView

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        homeviewPager2 = view.findViewById(R.id.homeimageslider)

        homeRecycleView = view.findViewById(R.id.homeRecycleView)

        listPopular = ArrayList()
        listPopular.add(PopularModel(R.drawable.pushup, "Push Up", "100 push up a day", "Intermediate"))
        listPopular.add(PopularModel(R.drawable.img, "Lower Body", "100 push up a day", "Intermediate"))
        listPopular.add(PopularModel(R.drawable.pushup, "Push Up", "100 push up a day", "Intermediate"))
        listPopular.add(PopularModel(R.drawable.pushup, "Push Up", "100 push up a day", "Intermediate"))

        popularAdapter = PopularAdapter(requireContext(), listPopular)

        homeRecycleView.layoutManager = LinearLayoutManager(requireContext())
        homeRecycleView.adapter = popularAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username: TextView = view.findViewById(R.id.user_name)

        // Получаем ViewModel
        userViewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        // Подписываемся на изменения имени пользователя
        userViewModel.userName.observe(viewLifecycleOwner) { name ->
            username.text = name
        }

        init()
        setTransfarmer()
        homeviewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

            fun OnPageSelected(position : Int){
                super.onPageSelected(position)
                homehandler.removeCallbacks(runnable)
                homehandler.postDelayed(runnable, 200)
            }

        })
    }

    private val runnable = Runnable{
        homeviewPager2.currentItem = homeviewPager2.currentItem + 1
    }


    private fun setTransfarmer() {

        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(10))
        transformer.addTransformer{page, position->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        homeviewPager2.setPageTransformer(transformer)

    }

    override fun onPause() {
        super.onPause()
        homehandler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        homehandler.postDelayed(runnable, 200)
    }

    private fun init() {

        homeimageList = ArrayList()
        homeadapter = ImageSliderAdapter(requireContext(), homeimageList, homeviewPager2)
        homehandler = Handler(Looper.myLooper()!!)

        homeimageList.add(R.drawable.populartrainone)
        homeimageList.add(R.drawable.populartrainone)
        homeimageList.add(R.drawable.populartraintwo)
        homeimageList.add(R.drawable.populartraintwo)

        homeviewPager2.adapter = homeadapter
        homeviewPager2.offscreenPageLimit = 3
        homeviewPager2.clipToPadding = false
        homeviewPager2.clipChildren = false
        homeviewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }
}