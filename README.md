# Super Picker with Crop

با استفاده از این کتابخانه به سادگی تصویر مورد نظر خود را از گالری انتخاب و یا از طریق دوربین بگیرید.
امکان برش و چرخش و تغییر سایز تصویر نیز فراهم شده است.
روش استفاده در زیر آموزش داده می شود:

Using this library, simply select your desired image from the gallery or take it through the camera.
It is also possible to cut, rotate and resize the image.
How to use is taught below:

for example / 
برای مثال
```java
    private void selectFromGallery(final Activity activity) {
        new PickerManagerBuilder(activity,true, PickerManagerBuilder.SELECT_FROM_GALLERY)
                .setOnImageReceivedListener(new PickerManagerBuilder.onImageReceivedListener() {
                    @Override
                    public void onImageReceived(Uri imageUri) {
                        Toast.makeText(activity,"Got image - " + imageUri, Toast.LENGTH_LONG).show();
                        imageView.setImageURI(imageUri)
                    }
                })
                .setImageName("avatar")
                .start();
    }
```

```java
    private void selectFromCamera(final Activity activity) {
        new PickerManagerBuilder(activity,true, PickerManagerBuilder.SELECT_FROM_CAMERA)
                .setOnImageReceivedListener(new PickerManagerBuilder.onImageReceivedListener() {
                    @Override
                    public void onImageReceived(Uri imageUri) {
                        Toast.makeText(activity,"Got image - " + imageUri, Toast.LENGTH_LONG).show();
                        imageView.setImageURI(imageUri);
                    }
                })
                .setImageName("avatar")
                .start();
    }
```

![alt text](https://raw.githubusercontent.com/yosefi1988/beautifulprogressbar/master/app/src/main/res/drawable/device20190917083815.gif)


