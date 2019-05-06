package ru.s4nchez.recyclerwithselection.adapter

interface OnItemClickListener<T> {
    fun onClick(item: T)
}