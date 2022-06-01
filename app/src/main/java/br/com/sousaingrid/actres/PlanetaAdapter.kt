package br.com.sousaingrid.actres

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PlanetaAdapter(
    val planetas: List<Planeta>,
    val onClick: (Planeta) -> Unit
):RecyclerView.Adapter<PlanetaAdapter.PlanetasViewHolder>(){
   class PlanetasViewHolder(view: View):
           RecyclerView.ViewHolder(view) {
       val cardNome: TextView
       val cardImg: ImageView
       val cardProgress: ProgressBar
       val cardView: CardView

       init {
           cardNome = view.findViewById(R.id.card_nome)
           cardImg = view.findViewById(R.id.card_img)
           cardProgress = view.findViewById(R.id.card_progress)
           cardView = view.findViewById(R.id.card_planetas)
         }

   }

    override fun getItemCount() = this.planetas.size

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): PlanetasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_planetas, parent,false)
        val holder = PlanetasViewHolder(view)

        return holder
    }

    override fun onBindViewHolder(
        holder: PlanetasViewHolder, position: Int) {

        val planeta = planetas[position]

        holder.cardNome.text = planeta.nome
        holder.cardProgress.visibility = View.VISIBLE

        Picasso.with(holder.itemView.context)
            .load(planeta.foto)
            .into(holder.cardImg, object: com.squareup.picasso.Callback {
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }

                override fun onError() {
                    holder.cardProgress.visibility = View.GONE
                }
            })


        holder.itemView.setOnClickListener{onClick(planeta)}
    }

}