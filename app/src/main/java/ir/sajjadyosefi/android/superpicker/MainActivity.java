package ir.sajjadyosefi.android.superpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import ir.sajjadyosefi.android.superpickerlibrary.PickerManagerBuilder;

public class MainActivity extends AppCompatActivity {
    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity activity = this;

        imageView = findViewById(R.id.imageView);
        ((Button)(findViewById(R.id.button))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFromGallery(activity);
            }
        });
    }

    private void selectFromGallery(final Activity activity) {
        new PickerManagerBuilder(activity, PickerManagerBuilder.SELECT_FROM_GALLERY)
                .setOnImageReceivedListener(new PickerManagerBuilder.onImageReceivedListener() {
                    @Override
                    public void onImageReceived(Uri imageUri) {
                        Toast.makeText(activity,"Got image - " + imageUri, Toast.LENGTH_LONG).show();
                        imageView.setImageURI(imageUri);

//                        File map1 = new File();
//                        map1.setTitle(LastFileSelected.substring(LastFileSelected.lastIndexOf("/")+1));
//                        map1.setRequestContentId(1);
//                        map1.setFrame(1);
//                        map1.setFileType(MAP_1);
//                        map1.setUri(LastFileSelected);
//                        map1.setType(FILES);
//                        Global.CurrentTask.sendToServerfileList.add(map1);
//                        adapter_Posts.notifyDataSetChanged();

                    }
                })
                .setImageName("avatar")
                .start();
    }
}
