// Generated by view binder compiler. Do not edit!
package com.live2d.demo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.live2d.demo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDashboardBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final Button buttonFloating;

  @NonNull
  public final Button buttonLoad;

  @NonNull
  public final EditText etName;

  @NonNull
  public final EditText etPath;

  @NonNull
  public final CoordinatorLayout glRoot;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final EditText scale;

  @NonNull
  public final Button showButton;

  @NonNull
  public final EditText x;

  @NonNull
  public final EditText y;

  private FragmentDashboardBinding(@NonNull CoordinatorLayout rootView,
      @NonNull Button buttonFloating, @NonNull Button buttonLoad, @NonNull EditText etName,
      @NonNull EditText etPath, @NonNull CoordinatorLayout glRoot, @NonNull ImageView imageView,
      @NonNull EditText scale, @NonNull Button showButton, @NonNull EditText x,
      @NonNull EditText y) {
    this.rootView = rootView;
    this.buttonFloating = buttonFloating;
    this.buttonLoad = buttonLoad;
    this.etName = etName;
    this.etPath = etPath;
    this.glRoot = glRoot;
    this.imageView = imageView;
    this.scale = scale;
    this.showButton = showButton;
    this.x = x;
    this.y = y;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDashboardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_dashboard, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDashboardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_floating;
      Button buttonFloating = ViewBindings.findChildViewById(rootView, id);
      if (buttonFloating == null) {
        break missingId;
      }

      id = R.id.button_load;
      Button buttonLoad = ViewBindings.findChildViewById(rootView, id);
      if (buttonLoad == null) {
        break missingId;
      }

      id = R.id.et_name;
      EditText etName = ViewBindings.findChildViewById(rootView, id);
      if (etName == null) {
        break missingId;
      }

      id = R.id.et_path;
      EditText etPath = ViewBindings.findChildViewById(rootView, id);
      if (etPath == null) {
        break missingId;
      }

      CoordinatorLayout glRoot = (CoordinatorLayout) rootView;

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.scale;
      EditText scale = ViewBindings.findChildViewById(rootView, id);
      if (scale == null) {
        break missingId;
      }

      id = R.id.show_button;
      Button showButton = ViewBindings.findChildViewById(rootView, id);
      if (showButton == null) {
        break missingId;
      }

      id = R.id.x;
      EditText x = ViewBindings.findChildViewById(rootView, id);
      if (x == null) {
        break missingId;
      }

      id = R.id.y;
      EditText y = ViewBindings.findChildViewById(rootView, id);
      if (y == null) {
        break missingId;
      }

      return new FragmentDashboardBinding((CoordinatorLayout) rootView, buttonFloating, buttonLoad,
          etName, etPath, glRoot, imageView, scale, showButton, x, y);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}