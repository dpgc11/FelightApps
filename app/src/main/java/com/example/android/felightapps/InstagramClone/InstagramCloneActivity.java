package com.example.android.felightapps.InstagramClone;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.felightapps.R;

public class InstagramCloneActivity extends AppCompatActivity {

    private ImageView mOriginalImageView;
    private ImageView mGrayScaleImageView;
    private ImageView mSepiaImageView;
    private ImageView mBlurImageView;
    private ImageView mResetImageView;
    private Bitmap mOriginalBitmap;

    final int CONTEXT_MENU_ZOOM_IN = 1;
    final int CONTEXT_MENU_ZOOM_OUT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_clone);

        mOriginalImageView = (ImageView) findViewById(R.id.iv_original_image);
        mGrayScaleImageView = (ImageView) findViewById(R.id.iv_grayScale);
        mSepiaImageView = (ImageView) findViewById(R.id.iv_sepia);
        mBlurImageView = (ImageView) findViewById(R.id.iv_blur);
        mResetImageView = (ImageView) findViewById(R.id.iv_reset_effects);

        mOriginalImageView.buildDrawingCache();
        mOriginalBitmap = mOriginalImageView.getDrawingCache();

        mOriginalImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(InstagramCloneActivity.this, mOriginalImageView, Gravity.CENTER);
                popupMenu.getMenuInflater().inflate(R.menu.instagram_popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menuItem_share_to_facebook:
                                //TODO:

                        }
                        return true;
                    }
                });

                popupMenu.show();
            }
        });

        mOriginalImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                registerForContextMenu(mOriginalImageView);
                openContextMenu(mOriginalImageView);
                return true;
            }
        });

        mGrayScaleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOriginalImageView.buildDrawingCache();
                Bitmap grayScaleBitmap = mOriginalImageView.getDrawingCache();
                grayScaleBitmap = toGrayscale(grayScaleBitmap);
                mOriginalImageView.setImageBitmap(grayScaleBitmap);
            }
        });

        mSepiaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOriginalImageView.buildDrawingCache();
                Bitmap sepiaBitmap = mOriginalImageView.getDrawingCache();
                Drawable sepiaDrawable = new BitmapDrawable(sepiaBitmap);
                setSepiaColorFilter(sepiaDrawable);
                mOriginalImageView.setImageDrawable(sepiaDrawable);
            }
        });

        mBlurImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOriginalImageView.buildDrawingCache();
                Bitmap blurBitmap = mOriginalImageView.getDrawingCache();
                Bitmap blurred = blurRenderScript(InstagramCloneActivity.this, blurBitmap, 20);
                mOriginalImageView.setImageBitmap(blurred);
            }
        });

        mResetImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOriginalImageView.setImageResource(R.drawable.imge);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
//            initEditImages();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select Zoom");
        menu.add(menu.NONE, CONTEXT_MENU_ZOOM_IN, menu.NONE, "Zoom In");
        menu.add(menu.NONE, CONTEXT_MENU_ZOOM_OUT, menu.NONE, "Zoom Out");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case CONTEXT_MENU_ZOOM_IN:
                Toast.makeText(getApplicationContext(), "Zoom In selected", Toast.LENGTH_SHORT).show();

                break;

            case CONTEXT_MENU_ZOOM_OUT:
                Toast.makeText(getApplicationContext(), "Zoom Out selected", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    // Image to Grayscale
    public Bitmap toGrayscale(Bitmap bmpOriginal) {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }

    // Image to Sepia
    public static void setSepiaColorFilter(Drawable drawable) {
        if (drawable == null)
            return;

        final ColorMatrix matrixA = new ColorMatrix();
        // making image B&W
        matrixA.setSaturation(0);

        final ColorMatrix matrixB = new ColorMatrix();
        // applying scales for RGB color values
        matrixB.setScale(1f, .95f, .82f, 1.0f);
        matrixA.setConcat(matrixB, matrixA);

        final ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrixA);
        drawable.setColorFilter(filter);
    }

//    public static void fetchImage() {
//        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.)
//    }

    private void initEditImages() {
        mGrayScaleImageView.buildDrawingCache();
        Bitmap grayScaleBitmap = mGrayScaleImageView.getDrawingCache();
        Bitmap grayScaleBm = toGrayscale(grayScaleBitmap);
        mGrayScaleImageView.setImageBitmap(grayScaleBm);
    }


    // Blur effect
    public static Bitmap blurRenderScript(Context context, Bitmap smallBitmap, int radius) {
        try {
            smallBitmap = RGB565toARGB888(smallBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Bitmap bitmap = Bitmap.createBitmap(
                smallBitmap.getWidth(), smallBitmap.getHeight(),
                Bitmap.Config.ARGB_8888);

        RenderScript renderScript = RenderScript.create(context);

        Allocation blurInput = Allocation.createFromBitmap(renderScript, smallBitmap);
        Allocation blurOutput = Allocation.createFromBitmap(renderScript, bitmap);

        ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(renderScript,
                Element.U8_4(renderScript));
        blur.setInput(blurInput);
        blur.setRadius(radius); // radius must be 0 < r <= 25
        blur.forEach(blurOutput);

        blurOutput.copyTo(bitmap);
        renderScript.destroy();

        return bitmap;

    }

    // Helper method for Blur effect
    private static Bitmap RGB565toARGB888(Bitmap img) throws Exception {
        int numPixels = img.getWidth() * img.getHeight();
        int[] pixels = new int[numPixels];

        //Get JPEG pixels.  Each int is the color values for one pixel.
        img.getPixels(pixels, 0, img.getWidth(), 0, 0, img.getWidth(), img.getHeight());

        //Create a Bitmap of the appropriate format.
        Bitmap result = Bitmap.createBitmap(img.getWidth(), img.getHeight(), Bitmap.Config.ARGB_8888);

        //Set RGB pixels.
        result.setPixels(pixels, 0, result.getWidth(), 0, 0, result.getWidth(), result.getHeight());
        return result;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressWarnings( "deprecation" )
    public static Intent shareImage(Context context, String pathToImage) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        else
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);

        shareIntent.setType("image/*");

        // For a file in shared storage.  For data in private storage, use a ContentProvider.
        Uri uri = Uri.fromFile(context.getFileStreamPath(pathToImage));
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        return shareIntent;
    }
}
