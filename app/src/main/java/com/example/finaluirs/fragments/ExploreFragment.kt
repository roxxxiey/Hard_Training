package com.example.finaluirs.fragments

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finaluirs.R
import com.example.finaluirs.adapters.BestAdapter
import com.example.finaluirs.models.BestModel


class ExploreFragment : Fragment() {

    private lateinit var best_trainRV: RecyclerView
    private lateinit var fast_warmupRV: RecyclerView
    private lateinit var bestAdapter: BestAdapter
    private lateinit var fastWarmup: BestAdapter
    private lateinit var itemList: ArrayList<BestModel>
    private lateinit var itemList2: ArrayList<BestModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        best_trainRV = view.findViewById(R.id.best_trainRV)
        fast_warmupRV = view.findViewById(R.id.fast_warmupRV)

        itemList = ArrayList()

        itemList.add(BestModel(R.drawable.pushup, "Geometry", "10$", "asdad"))
        itemList.add(BestModel(R.drawable.pushup, "Geometry", "10$", "asdad"))
        itemList.add(BestModel(R.drawable.pushup, "Geometry", "10$", "asdad"))
        itemList.add(BestModel(R.drawable.pushup, "Geometry", "10$", "asdad"))

        itemList2 = ArrayList()
        itemList2.add(BestModel(R.drawable.pushup, "Geometry", "10$", "asdad"))
        itemList2.add(BestModel(R.drawable.pushup, "Geometry", "10$", "asdad"))
        itemList2.add(BestModel(R.drawable.pushup, "Geometry", "10$", "asdad"))


        best_trainRV.layoutManager = GridLayoutManager(context, 1) //Если поменять размер можельки то влезет и по две

        fast_warmupRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val spaceSize = resources.getDimensionPixelSize(R.dimen.space_between_items_horizontal) // Замените на ваш ресурс
        fast_warmupRV.addItemDecoration(HorizontalSpaceItemDecoration(spaceSize))


        bestAdapter = BestAdapter(requireContext(), itemList)
        best_trainRV.adapter = bestAdapter

        fastWarmup = BestAdapter(requireContext(), itemList2)
        fast_warmupRV.adapter = fastWarmup

        return view
    }

}

class HorizontalSpaceItemDecoration(private val spaceSize: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        // Добавляем расстояние только между элементами (не после последнего элемента)
        if (parent.getChildAdapterPosition(view) != parent.adapter?.itemCount?.minus(1)) {
            outRect.right = spaceSize
        }
    }
}
