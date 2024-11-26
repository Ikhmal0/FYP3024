package com.example.sweetbakery2.databinding;
import com.example.sweetbakery2.R;
import com.example.sweetbakery2.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemOrderBindingImpl extends ItemOrderBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemOrderBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ItemOrderBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[3]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvOrderName.setTag(null);
        this.tvQuantity.setTag(null);
        this.tvStatus.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.order == variableId) {
            setOrder((com.example.sweetbakery2.model.Order) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setOrder(@Nullable com.example.sweetbakery2.model.Order Order) {
        this.mOrder = Order;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.order);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String orderStatus = null;
        java.lang.String javaLangStringStatusOrderStatus = null;
        java.lang.String javaLangStringNameOrderProductName = null;
        java.lang.String javaLangStringQuantityOrderQuantity = null;
        int orderQuantity = 0;
        com.example.sweetbakery2.model.Order order = mOrder;
        java.lang.String orderProductName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (order != null) {
                    // read order.status
                    orderStatus = order.getStatus();
                    // read order.quantity
                    orderQuantity = order.getQuantity();
                    // read order.productName
                    orderProductName = order.getProductName();
                }


                // read ("Status: ") + (order.status)
                javaLangStringStatusOrderStatus = ("Status: ") + (orderStatus);
                // read ("Quantity: ") + (order.quantity)
                javaLangStringQuantityOrderQuantity = ("Quantity: ") + (orderQuantity);
                // read ("Name: ") + (order.productName)
                javaLangStringNameOrderProductName = ("Name: ") + (orderProductName);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvOrderName, javaLangStringNameOrderProductName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvQuantity, javaLangStringQuantityOrderQuantity);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvStatus, javaLangStringStatusOrderStatus);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): order
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}