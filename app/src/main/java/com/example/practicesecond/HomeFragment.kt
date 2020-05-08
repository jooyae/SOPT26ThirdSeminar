package com.example.practicesecond


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home2.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var instaAdapter: InstaAdapter
    val datas = mutableListOf<InstaData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instaAdapter = InstaAdapter(view.context)
        rv_home.adapter = instaAdapter
        loadDatas()
    }

    private  fun loadDatas(){
        datas.apply {
            add(
                InstaData(
                    userName = "박주예",
                    img_profile = "https://image-notepet.akamaized.net/resize/620x-/seimage/20190816%2Ff07bd9f247293aa0317f2c8faba7e83b.png",
                    img_contents = "https://image-notepet.akamaized.net/resize/620x-/seimage/20190816%2F41d1b68f2fa91f57a41262b3df554d26.png"

                    )
            )
            add(
                InstaData(
                    userName = "안드로이드",
                    img_profile = "https://image-notepet.akamaized.net/resize/620x-/seimage/20190816%2F78fa1190066df65764a9cb49f597ad7e.png",
                    img_contents = "https://image-notepet.akamaized.net/resize/620x-/seimage/20190816%2F410e4ce95b5506e48e32c971f971ce4b.png"

                )
            )
            add(
                InstaData(
                    userName = "26기",
                    img_profile = "https://image-notepet.akamaized.net/resize/620x-/seimage/20190816%2F8a16940b6dba12fce66675f5293e404b.png",
                    img_contents = "https://pds.joins.com/news/component/htmlphoto_mmdata/201909/01/136ad58b-b410-4db8-939b-ec0b40b9d1f5.jpg"

                )
            )
        }
        instaAdapter.datas = datas
        instaAdapter.notifyDataSetChanged()
    }
}
