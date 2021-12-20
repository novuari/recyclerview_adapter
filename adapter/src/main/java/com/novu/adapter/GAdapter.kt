package com.novu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class GAdapter<E>(
    val itemLayoutId: Int,
    val variableId: Int,
    val listener: BaseListener<E>? = null
): RecyclerView.Adapter<GAdapter<E>.ViewHolder>() {

    private val mList = arrayListOf<E>()

    fun setList(list: List<E>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    fun getList(): List<E> = mList
    fun getCopyOfList(): List<E> = ArrayList(mList)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), itemLayoutId, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(mList[position], position)

    override fun getItemCount(): Int = mList.size

    inner class ViewHolder(val viewItem: ViewDataBinding): RecyclerView.ViewHolder(viewItem.root) {
        fun bind(element: E, position: Int) {
            viewItem.setVariable(variableId, element)
            viewItem.executePendingBindings()

            viewItem.root.setOnClickListener {
                listener?.onClickItem(element, position)
            }
        }
    }

    interface BaseListener<E> {
        fun onClickItem(item: E, position: Int)
    }
}