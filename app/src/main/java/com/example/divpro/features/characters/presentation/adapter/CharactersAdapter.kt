package com.example.divpro.features.characters.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources.Theme
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.divpro.R
import com.example.divpro.databinding.ItemCharacterBinding
import com.example.divpro.features.characters.domain.model.Result

class CharactersAdapter(
    private val characters: List<Result>,
    private val context: Context
): RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {

    class CharactersViewHolder(view: View): ViewHolder(view) {

        private val viewBinding: ItemCharacterBinding by viewBinding(ItemCharacterBinding::bind)

        @SuppressLint("SetTextI18n")
        fun bind(character: Result, context: Context){
            viewBinding.tvCharacterName.text = character.name
            viewBinding.tvCharacterInfo.text = "${character.species}, ${character.gender}"
            Glide.with(viewBinding.ivCharacterImage).load(character.image).into(viewBinding.ivCharacterImage)
            viewBinding.tvCharacterLocation.text = character.location.name
            when(character.status){
                Status.ALIVE.value -> {
                    viewBinding.cvStatus.setCardBackgroundColor(context.resources.getColor(R.color.light_green, null))
                    viewBinding.tvStatus.setTextColor(context.resources.getColor(R.color.green, null))
                    viewBinding.tvStatus.text = Status.ALIVE.value
                }
                Status.DEAD.value -> {
                    viewBinding.cvStatus.setCardBackgroundColor(context.resources.getColor(R.color.light_red, null))
                    viewBinding.tvStatus.setTextColor(context.resources.getColor(R.color.red))
                    viewBinding.tvStatus.text = Status.DEAD.value
                }
                Status.UNKNOWN.value -> {
                    viewBinding.cvStatus.setCardBackgroundColor(context.resources.getColor(R.color.light_grey, null))
                    viewBinding.tvStatus.setTextColor(context.resources.getColor(R.color.text_grey, null))
                    viewBinding.tvStatus.text = Status.UNKNOWN.value
                }else -> {
                viewBinding.cvStatus.setCardBackgroundColor(context.resources.getColor(R.color.light_grey, null))
                viewBinding.tvStatus.setTextColor(context.resources.getColor(R.color.text_grey, null))
                viewBinding.tvStatus.text = Status.UNKNOWN.value
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharactersViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(characters[position], context)
    }
}

enum class Status(val value: String) {
    ALIVE("Alive"), DEAD("Dead"), UNKNOWN("Unknown")
}