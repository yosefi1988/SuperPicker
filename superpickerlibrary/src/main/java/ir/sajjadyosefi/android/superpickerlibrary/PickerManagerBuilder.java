package ir.sajjadyosefi.android.superpickerlibrary;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;


/**
 * Created by Mickael on 13/10/2016.
 */

public class PickerManagerBuilder {
    public static final int SELECT_FROM_GALLERY = 0;
    public static final int SELECT_FROM_CAMERA = 1;
    private Activity activity;
    private boolean crop;
    private onPermissionRefusedListener permissionRefusedListener;
    protected onImageReceivedListener imageReceivedListener;
    private PickerManager pickerManager;
    public PickerManagerBuilder(Activity activity, boolean crop, int type)
    {
        this.activity = activity;
        this.crop = crop;
        pickerManager = (type == PickerManagerBuilder.SELECT_FROM_GALLERY) ? new ImagePickerManager(activity) : new CameraPickerManager(activity);

    }


    public interface onPermissionRefusedListener {
        void onPermissionRefused();
    }

    public interface onImageReceivedListener{
        void onImageReceived(Uri imageUri);
    }


    public void start() {
        Intent intent = new Intent(activity, TempActivity.class);
        activity.startActivity(intent);

        GlobalHolder.getInstance().setPickerManager(pickerManager);

    }

    public PickerManagerBuilder setOnImageReceivedListener(onImageReceivedListener listener) {
        pickerManager.setOnImageReceivedListener(listener);
        return this;
    }

    public PickerManagerBuilder setOnPermissionRefusedListener(onPermissionRefusedListener listener) {
        pickerManager.setOnPermissionRefusedListener(listener);
        return this;
    }

    public PickerManagerBuilder setCropScreenColor(int cropScreenColor) {
        pickerManager.setCropActivityColor(cropScreenColor);
        return this;
    }

    public PickerManagerBuilder setImageName(String imageName) {
        pickerManager.setImageName(imageName);
        return this;
    }

    public PickerManagerBuilder withTimeStamp(boolean withTimeStamp) {
        pickerManager.withTimeStamp(withTimeStamp);
        return this;
    }

    public PickerManagerBuilder setImageFolderName(String folderName) {
        pickerManager.setImageFolderName(folderName);
        return this;
    }

//    public PickerBuilder setCustomizedUcrop(UCrop ucrop) {
//        pickerManager.setCustomizedUcrop(ucrop);
//        return this;
//    }

}