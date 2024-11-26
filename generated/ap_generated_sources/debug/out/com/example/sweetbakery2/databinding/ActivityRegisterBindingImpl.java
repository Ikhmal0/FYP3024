package com.example.sweetbakery2.databinding;
import com.example.sweetbakery2.R;
import com.example.sweetbakery2.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityRegisterBindingImpl extends ActivityRegisterBinding implements com.example.sweetbakery2.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.btnGoToLogin, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener eTEmailandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.email.getValue()
            //         is viewModel.email.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(eTEmail);
            // localize variables for thread safety
            // viewModel.email.getValue()
            java.lang.String viewModelEmailGetValue = null;
            // viewModel.email
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelEmail = null;
            // viewModel
            com.example.sweetbakery2.viewmodel.RegisterViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.email != null
            boolean viewModelEmailJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelEmail = viewModel.getEmail();

                viewModelEmailJavaLangObjectNull = (viewModelEmail) != (null);
                if (viewModelEmailJavaLangObjectNull) {




                    viewModelEmail.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener eTNameandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.name.getValue()
            //         is viewModel.name.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(eTName);
            // localize variables for thread safety
            // viewModel.name != null
            boolean viewModelNameJavaLangObjectNull = false;
            // viewModel.name
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelName = null;
            // viewModel
            com.example.sweetbakery2.viewmodel.RegisterViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.name.getValue()
            java.lang.String viewModelNameGetValue = null;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelName = viewModel.getName();

                viewModelNameJavaLangObjectNull = (viewModelName) != (null);
                if (viewModelNameJavaLangObjectNull) {




                    viewModelName.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener eTPasswordandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.password.getValue()
            //         is viewModel.password.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(eTPassword);
            // localize variables for thread safety
            // viewModel.password != null
            boolean viewModelPasswordJavaLangObjectNull = false;
            // viewModel.password.getValue()
            java.lang.String viewModelPasswordGetValue = null;
            // viewModel
            com.example.sweetbakery2.viewmodel.RegisterViewModel viewModel = mViewModel;
            // viewModel.password
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelPassword = null;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelPassword = viewModel.getPassword();

                viewModelPasswordJavaLangObjectNull = (viewModelPassword) != (null);
                if (viewModelPasswordJavaLangObjectNull) {




                    viewModelPassword.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener eTRoleandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.role.getValue()
            //         is viewModel.role.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(eTRole);
            // localize variables for thread safety
            // viewModel.role
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelRole = null;
            // viewModel.role.getValue()
            java.lang.String viewModelRoleGetValue = null;
            // viewModel
            com.example.sweetbakery2.viewmodel.RegisterViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.role != null
            boolean viewModelRoleJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelRole = viewModel.getRole();

                viewModelRoleJavaLangObjectNull = (viewModelRole) != (null);
                if (viewModelRoleJavaLangObjectNull) {




                    viewModelRole.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityRegisterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ActivityRegisterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (android.widget.Button) bindings[6]
            , (android.widget.Button) bindings[5]
            , (android.widget.EditText) bindings[2]
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[3]
            , (android.widget.EditText) bindings[4]
            );
        this.btnRegister.setTag(null);
        this.eTEmail.setTag(null);
        this.eTName.setTag(null);
        this.eTPassword.setTag(null);
        this.eTRole.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.sweetbakery2.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
        if (BR.viewModel == variableId) {
            setViewModel((com.example.sweetbakery2.viewmodel.RegisterViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.example.sweetbakery2.viewmodel.RegisterViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelEmail((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelName((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewModelRole((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeViewModelPassword((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelEmail(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelName(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelName, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelRole(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelRole, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelPassword(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
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
        java.lang.String viewModelEmailGetValue = null;
        java.lang.String viewModelPasswordGetValue = null;
        java.lang.String viewModelNameGetValue = null;
        java.lang.String viewModelRoleGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelEmail = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelName = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelRole = null;
        com.example.sweetbakery2.viewmodel.RegisterViewModel viewModel = mViewModel;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelPassword = null;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.email
                        viewModelEmail = viewModel.getEmail();
                    }
                    updateLiveDataRegistration(0, viewModelEmail);


                    if (viewModelEmail != null) {
                        // read viewModel.email.getValue()
                        viewModelEmailGetValue = viewModelEmail.getValue();
                    }
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.name
                        viewModelName = viewModel.getName();
                    }
                    updateLiveDataRegistration(1, viewModelName);


                    if (viewModelName != null) {
                        // read viewModel.name.getValue()
                        viewModelNameGetValue = viewModelName.getValue();
                    }
            }
            if ((dirtyFlags & 0x34L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.role
                        viewModelRole = viewModel.getRole();
                    }
                    updateLiveDataRegistration(2, viewModelRole);


                    if (viewModelRole != null) {
                        // read viewModel.role.getValue()
                        viewModelRoleGetValue = viewModelRole.getValue();
                    }
            }
            if ((dirtyFlags & 0x38L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.password
                        viewModelPassword = viewModel.getPassword();
                    }
                    updateLiveDataRegistration(3, viewModelPassword);


                    if (viewModelPassword != null) {
                        // read viewModel.password.getValue()
                        viewModelPasswordGetValue = viewModelPassword.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            this.btnRegister.setOnClickListener(mCallback1);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.eTEmail, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, eTEmailandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.eTName, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, eTNameandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.eTPassword, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, eTPasswordandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.eTRole, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, eTRoleandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.eTEmail, viewModelEmailGetValue);
        }
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.eTName, viewModelNameGetValue);
        }
        if ((dirtyFlags & 0x38L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.eTPassword, viewModelPasswordGetValue);
        }
        if ((dirtyFlags & 0x34L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.eTRole, viewModelRoleGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel.email.getValue()
        java.lang.String viewModelEmailGetValue = null;
        // viewModel.email
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelEmail = null;
        // viewModel.password.getValue()
        java.lang.String viewModelPasswordGetValue = null;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;
        // viewModel.name.getValue()
        java.lang.String viewModelNameGetValue = null;
        // viewModel.email != null
        boolean viewModelEmailJavaLangObjectNull = false;
        // viewModel.password != null
        boolean viewModelPasswordJavaLangObjectNull = false;
        // viewModel.name != null
        boolean viewModelNameJavaLangObjectNull = false;
        // viewModel.name
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelName = null;
        // viewModel.role
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelRole = null;
        // viewModel.role.getValue()
        java.lang.String viewModelRoleGetValue = null;
        // viewModel
        com.example.sweetbakery2.viewmodel.RegisterViewModel viewModel = mViewModel;
        // viewModel.password
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelPassword = null;
        // viewModel.role != null
        boolean viewModelRoleJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {




            viewModelName = viewModel.getName();

            viewModelNameJavaLangObjectNull = (viewModelName) != (null);
            if (viewModelNameJavaLangObjectNull) {


                viewModelNameGetValue = viewModelName.getValue();



                viewModelEmail = viewModel.getEmail();

                viewModelEmailJavaLangObjectNull = (viewModelEmail) != (null);
                if (viewModelEmailJavaLangObjectNull) {


                    viewModelEmailGetValue = viewModelEmail.getValue();



                    viewModelPassword = viewModel.getPassword();

                    viewModelPasswordJavaLangObjectNull = (viewModelPassword) != (null);
                    if (viewModelPasswordJavaLangObjectNull) {


                        viewModelPasswordGetValue = viewModelPassword.getValue();



                        viewModelRole = viewModel.getRole();

                        viewModelRoleJavaLangObjectNull = (viewModelRole) != (null);
                        if (viewModelRoleJavaLangObjectNull) {


                            viewModelRoleGetValue = viewModelRole.getValue();

                            viewModel.registerUser(viewModelNameGetValue, viewModelEmailGetValue, viewModelPasswordGetValue, viewModelRoleGetValue);
                        }
                    }
                }
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.email
        flag 1 (0x2L): viewModel.name
        flag 2 (0x3L): viewModel.role
        flag 3 (0x4L): viewModel.password
        flag 4 (0x5L): viewModel
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}