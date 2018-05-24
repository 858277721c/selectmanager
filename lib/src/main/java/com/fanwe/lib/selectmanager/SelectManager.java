package com.fanwe.lib.selectmanager;

import java.util.List;

interface SelectManager<T>
{
    /**
     * 添加回调对象
     *
     * @param callback
     */
    void addCallback(Callback<T> callback);

    /**
     * 移除回调对象
     *
     * @param callback
     */
    void removeCallback(Callback<T> callback);

    /**
     * 设置选择模式
     *
     * @param mode
     */
    void setMode(Mode mode);

    /**
     * 返回当前的选择模式
     *
     * @return
     */
    Mode getMode();

    /**
     * item是否被选中
     *
     * @param item
     * @return
     */
    boolean isSelected(T item);

    /**
     * 返回当前选中的位置，{@link Mode#isSingleType()} == true 的时候才可以调用此方法
     *
     * @return
     */
    int getSelectedIndex();

    /**
     * 返回当前选中的位置，{@link Mode#isSingleType()} == false 的时候才可以调用此方法
     *
     * @return
     */
    List<Integer> getSelectedIndexs();

    /**
     * 返回当前选中的item，{@link Mode#isSingleType()} == true 的时候才可以调用此方法
     *
     * @return
     */
    T getSelectedItem();

    /**
     * 返回当前选中的item，{@link Mode#isSingleType()} == false 的时候才可以调用此方法
     *
     * @return
     */
    List<T> getSelectedItems();

    /**
     * 全部选中，{@link Mode#isSingleType()} == false 的时候才可以调用此方法
     */
    void selectAll();

    /**
     * 模拟点击该位置
     *
     * @param index
     */
    void performClick(int index);

    /**
     * 设置该位置的选中状态
     *
     * @param index
     * @param selected
     */
    void setSelected(int index, boolean selected);

    /**
     * 模拟点击该项
     *
     * @param item
     */
    void performClick(T item);

    /**
     * 设置该项的选中状态
     *
     * @param item
     * @param selected
     */
    void setSelected(T item, boolean selected);

    /**
     * 清空选中的项
     */
    void clearSelected();

    /**
     * 返回item的位置
     *
     * @param item
     * @return
     */
    int indexOf(T item);

    //---------- data start ----------

    void setItems(T... items);

    void setItems(List<T> items);

    void appendItems(List<T> items);

    void appendItem(T item);

    void removeItem(T item);

    void insertItem(int index, T item);

    void insertItem(int index, List<T> items);

    void updateItem(int index, T item);

    //---------- data end ----------

    enum Mode
    {
        /**
         * 单选，必须选中一项
         */
        SINGLE_MUST_ONE_SELECTED,
        /**
         * 单选，可以一项都没选中
         */
        SINGLE,
        /**
         * 多选，必须选中一项
         */
        MULTI_MUST_ONE_SELECTED,
        /**
         * 多选，可以一项都没选中
         */
        MULTI;

        /**
         * 是否是单选类型，{@link Mode#SINGLE}或者{@link Mode#SINGLE_MUST_ONE_SELECTED}
         *
         * @return
         */
        public boolean isSingleType()
        {
            return this == SINGLE || this == SINGLE_MUST_ONE_SELECTED;
        }
    }

    interface Callback<T>
    {
        /**
         * 状态变化回调
         *
         * @param selected true-选中，false-未选中
         * @param item
         */
        void onSelectedChanged(boolean selected, T item);
    }

    interface Selectable
    {
        boolean isSelected();

        void setSelected(boolean selected);
    }

    class SelectableModel implements FSelectManager.Selectable
    {
        private boolean selected;

        @Override
        public boolean isSelected()
        {
            return selected;
        }

        @Override
        public void setSelected(boolean selected)
        {
            this.selected = selected;
        }
    }
}
