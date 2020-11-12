package com.sd.lib.selectmanager

interface SelectManagerKt<T>
{
    /**
     * 添加回调对象
     */
    fun addCallback(callback: Callback<T>)

    /**
     * 移除回调对象
     */
    fun removeCallback(callback: Callback<T>)

    /**
     * 设置回调对象
     */
    fun setItemInitCallback(callback: ItemInitCallback<T>)

    /**
     * 添加拦截对象
     */
    fun addStateInterceptor(interceptor: StateInterceptor<T>)

    /**
     * 移除拦截悐
     */
    fun removeStateInterceptor(interceptor: StateInterceptor<T>)

    /**
     * 设置模式
     * @param mode
     */
    fun setMode(mode: Mode)

    /**
     * 返回当前的模式
     * @return
     */
    fun getMode(): Mode

    /**
     * 设置是否至少选中一项，默认true
     * @param selectOneAtLeast
     */
    fun setSelectOneAtLeast(selectOneAtLeast: Boolean)

    /**
     * Item是否被选中
     */
    fun isSelected(item: T): Boolean

    /**
     * 返回选中的位置，单选模式才可以调用此方法
     * @return
     */
    fun getSelectedIndex(): Int

    /**
     * 返回选中的位置，多选模式才可以调用此方法
     * @return
     */
    fun getSelectedIndexs(): List<Int>

    /**
     * 返回选中的项，单选模式才可以调用此方法
     */
    fun getSelectedItem(): T

    /**
     * 返回选中的项，多选模式才可以调用此方法
     */
    fun getSelectedItems(): List<T>

    /**
     * 全选，多选模式才可以调用此方法
     */
    fun selectAll()

    /**
     * 模拟点击该位置
     * @param index
     */
    fun performClick(index: Int)

    /**
     * 模拟点击该项
     * @param item
     */
    fun performClick(item: T)

    /**
     * 设置该位置的选中状态
     * @param index
     * @param item
     */
    fun setSelected(index: Int, selected: Boolean)

    /**
     * 设置该项的选中状态
     * @param item
     * @param selected
     */
    fun setSelected(item: T, selected: Boolean)

    /**
     * 清空选中的项
     */
    fun clearSelected()

    /**
     * 返回Item的位置
     * @return
     */
    fun indexOf(item: T): Int

    //---------- data start ----------

    /**
     * 设置数据
     * @param items
     */
    fun setItems(vararg items: T)

    /**
     * 设置数据
     * @param items
     */
    fun setItems(items: List<T>)

    /**
     * 添加数据
     * @param item
     */
    fun addItem(item: T)

    /**
     * 添加数据
     * @param items
     */
    fun addItems(items: List<T>)

    /**
     * 在index位置添加数据
     * @param index
     * @param item
     */
    fun addItem(index: Int, item: T)

    /**
     * 在index位置添加数据
     * @param index
     * @param items
     */
    fun addItems(index: Int, items: List<T>)

    /**
     * 移除数据
     * @param item
     */
    fun removeItem(item: T)

    /**
     * 更新index位置的数据
     * @param index
     * @param item
     */
    fun updateItem(index: Int, item: T)

    enum class Mode
    {
        /**单选*/
        single,

        /**多选*/
        multi
    }

    interface Callback<T>
    {
        /**
         * 状态变化回调
         *
         * @param selected true-选中，false-未选中
         * @param item
         */
        fun onSelectedChanged(selected: Boolean, item: T)
    }

    interface ItemInitCallback<T>
    {
        /**
         * Item初始化回调
         */
        fun initItem(item: T)
    }

    interface StateInterceptor<T>
    {
        /**
         * 拦截
         *
         * @param item
         * @param selected
         * @return true-拦截掉
         */
        fun interceptItem(item: T, selected: Boolean): Boolean
    }

    interface SingleSelectCallback<T>
    {
        /**
         * 单选模式下，选中项回调
         * @param item
         */
        fun onSelectedChanged(item: T);
    }
}