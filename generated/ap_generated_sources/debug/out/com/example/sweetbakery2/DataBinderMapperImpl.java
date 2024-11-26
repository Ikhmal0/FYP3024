package com.example.sweetbakery2;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.sweetbakery2.databinding.ActivityAddProductBindingImpl;
import com.example.sweetbakery2.databinding.ActivityCustomerBindingImpl;
import com.example.sweetbakery2.databinding.ActivityLoginBindingImpl;
import com.example.sweetbakery2.databinding.ActivityOrderBindingImpl;
import com.example.sweetbakery2.databinding.ActivityProductAdapterBindingImpl;
import com.example.sweetbakery2.databinding.ActivityRegisterBindingImpl;
import com.example.sweetbakery2.databinding.ActivityViewCustomerOrdersBindingImpl;
import com.example.sweetbakery2.databinding.ActivityViewOrdersBindingImpl;
import com.example.sweetbakery2.databinding.ItemOrderBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYADDPRODUCT = 1;

  private static final int LAYOUT_ACTIVITYCUSTOMER = 2;

  private static final int LAYOUT_ACTIVITYLOGIN = 3;

  private static final int LAYOUT_ACTIVITYORDER = 4;

  private static final int LAYOUT_ACTIVITYPRODUCTADAPTER = 5;

  private static final int LAYOUT_ACTIVITYREGISTER = 6;

  private static final int LAYOUT_ACTIVITYVIEWCUSTOMERORDERS = 7;

  private static final int LAYOUT_ACTIVITYVIEWORDERS = 8;

  private static final int LAYOUT_ITEMORDER = 9;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(9);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.sweetbakery2.R.layout.activity_add_product, LAYOUT_ACTIVITYADDPRODUCT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.sweetbakery2.R.layout.activity_customer, LAYOUT_ACTIVITYCUSTOMER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.sweetbakery2.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.sweetbakery2.R.layout.activity_order, LAYOUT_ACTIVITYORDER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.sweetbakery2.R.layout.activity_product_adapter, LAYOUT_ACTIVITYPRODUCTADAPTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.sweetbakery2.R.layout.activity_register, LAYOUT_ACTIVITYREGISTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.sweetbakery2.R.layout.activity_view_customer_orders, LAYOUT_ACTIVITYVIEWCUSTOMERORDERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.sweetbakery2.R.layout.activity_view_orders, LAYOUT_ACTIVITYVIEWORDERS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.sweetbakery2.R.layout.item_order, LAYOUT_ITEMORDER);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYADDPRODUCT: {
          if ("layout/activity_add_product_0".equals(tag)) {
            return new ActivityAddProductBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_add_product is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCUSTOMER: {
          if ("layout/activity_customer_0".equals(tag)) {
            return new ActivityCustomerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_customer is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYLOGIN: {
          if ("layout/activity_login_0".equals(tag)) {
            return new ActivityLoginBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYORDER: {
          if ("layout/activity_order_0".equals(tag)) {
            return new ActivityOrderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_order is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPRODUCTADAPTER: {
          if ("layout/activity_product_adapter_0".equals(tag)) {
            return new ActivityProductAdapterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_product_adapter is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYREGISTER: {
          if ("layout/activity_register_0".equals(tag)) {
            return new ActivityRegisterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_register is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYVIEWCUSTOMERORDERS: {
          if ("layout/activity_view_customer_orders_0".equals(tag)) {
            return new ActivityViewCustomerOrdersBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_view_customer_orders is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYVIEWORDERS: {
          if ("layout/activity_view_orders_0".equals(tag)) {
            return new ActivityViewOrdersBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_view_orders is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMORDER: {
          if ("layout/item_order_0".equals(tag)) {
            return new ItemOrderBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_order is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(3);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "order");
      sKeys.put(2, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(9);

    static {
      sKeys.put("layout/activity_add_product_0", com.example.sweetbakery2.R.layout.activity_add_product);
      sKeys.put("layout/activity_customer_0", com.example.sweetbakery2.R.layout.activity_customer);
      sKeys.put("layout/activity_login_0", com.example.sweetbakery2.R.layout.activity_login);
      sKeys.put("layout/activity_order_0", com.example.sweetbakery2.R.layout.activity_order);
      sKeys.put("layout/activity_product_adapter_0", com.example.sweetbakery2.R.layout.activity_product_adapter);
      sKeys.put("layout/activity_register_0", com.example.sweetbakery2.R.layout.activity_register);
      sKeys.put("layout/activity_view_customer_orders_0", com.example.sweetbakery2.R.layout.activity_view_customer_orders);
      sKeys.put("layout/activity_view_orders_0", com.example.sweetbakery2.R.layout.activity_view_orders);
      sKeys.put("layout/item_order_0", com.example.sweetbakery2.R.layout.item_order);
    }
  }
}
