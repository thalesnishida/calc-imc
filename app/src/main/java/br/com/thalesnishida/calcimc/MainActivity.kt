package br.com.thalesnishida.calcimc

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    private  lateinit var rvMain: RecyclerView
//    private lateinit var btnImc: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainItems = mutableListOf<MainItem>()
        mainItems.add(
            MainItem(
                id = 1,
                drawableId = R.drawable.baseline_wb_sunny_24,
                texStringId = R.string.label_imc,
                color = Color.GREEN
            )
        )

        val adapter = MainAdapter(mainItems)
        rvMain = findViewById(R.id.rvMain)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)


    }

    private inner class MainAdapter(private val mainItems: List<MainItem>): RecyclerView.Adapter<MainViewHolder>() {
        // Qual layout xml da celula especifica (item)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = layoutInflater.inflate(R.layout.main_item, parent, false)
            return MainViewHolder(view)
        }

        // 2 - Metodo que vai ser disparado toda vez que tiver uma rolagem na tela
        override fun getItemCount(): Int {
            return mainItems.size
        }

        // Quantos items vai ser disponibilizado na tela
        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val currentItem = mainItems[position]
            holder.bind(currentItem)
        }

    }


    // Essa é classe que vai buscar as referencias
    private class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: MainItem){
            val img: ImageView = itemView.findViewById(R.id.item_img_icon)
            val text: TextView = itemView.findViewById(R.id.item_text)
            val container: LinearLayout = itemView as LinearLayout

            img.setImageResource(item.drawableId)
            text.setText(item.texStringId)
            container.setBackgroundColor(item.color)
        }
    }


}