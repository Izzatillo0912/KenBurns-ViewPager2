package arfo.developer.motionviewpager

import android.R.interpolator
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import arfo.developer.motionviewpager.databinding.ItemViewPagerBinding
import com.flaviofaria.kenburnsview.RandomTransitionGenerator
import com.squareup.picasso.Picasso


class Adapter(private val imageList: ArrayList<Model>) : RecyclerView.Adapter<Adapter.CityVieHolder>() {

    inner class CityVieHolder(val binding: ItemViewPagerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityVieHolder {
        return CityVieHolder(ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CityVieHolder, position: Int) {
        val item = imageList[position]
        with(holder) {
            Picasso.get().load(item.image).into(binding.kbvLocation)
        }
    }

    override fun getItemCount(): Int = imageList.size

}