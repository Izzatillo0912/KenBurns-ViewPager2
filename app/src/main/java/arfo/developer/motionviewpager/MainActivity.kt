package arfo.developer.motionviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import arfo.developer.motionviewpager.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = ArrayList<Model>()
        imageList.add(Model("https://zamzam.com/blog/wp-content/uploads/2021/08/cover.jpg"))
        imageList.add(Model("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUd2_ZfiXRuwS4O5mbYT_7Cjpwtd8dMMUiew&usqp=CAU"))
        imageList.add(Model("https://cdn.ceoworld.biz/wp-content/uploads/2019/12/Paris-France.jpg"))
        imageList.add(Model("https://images.dailyhive.com/20190121105514/shutterstock_739779886.jpg"))
        imageList.add(Model("https://planetofhotels.com/guide/sites/default/files/styles/paragraph__text_with_image___twi_image/public/2021-02/Singapore-2.jpg"))
        imageList.add(Model("https://775189.smushcdn.com/1166980/wp-content/uploads/2020/02/Rio-most-beuatiful-cities-in-the-world.jpg?size=1150x700&lossy=1&strip=1&webp=0"))

        binding.viewPager.adapter = Adapter(imageList)
        binding.viewPager.clipToPadding = false
        binding.viewPager.clipChildren = false
        binding.viewPager.offscreenPageLimit = 6
        binding.viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(0))
        compositePageTransformer.addTransformer { page, position ->
            val r : Float = 1 - abs(position)
            page.scaleY = 0.95f + r * 0.05f
        }

        binding.viewPager.setPageTransformer(compositePageTransformer)
    }
}