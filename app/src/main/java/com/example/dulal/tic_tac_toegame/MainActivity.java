package com.example.dulal.tic_tac_toegame;

import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    int count=0;
    int player = 0;
    int[] GameFilup = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winnerposition = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}, {0, 4, 8, 12},
            {1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, {0, 5, 10, 15}, {3, 6, 9, 12}};
    boolean winner = false;
    String msg;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void gamelogic(View view) {
        count++;
        ImageView tappedview = (ImageView) view;
        int GameTag = Integer.parseInt(view.getTag().toString());

        if (player == 0 && GameFilup[GameTag] == 2 && !winner) {
            tappedview.setTranslationX(-3000f);
            tappedview.setImageResource(R.drawable.disk1);
            tappedview.animate().translationXBy(3000f).setDuration(500);
            player = 1;
            GameFilup[GameTag] = 0;
        } else if (player == 1 && GameFilup[GameTag] == 2 && !winner) {
            tappedview.setTranslationX(-3000f);
            tappedview.setImageResource(R.drawable.disk2);
            tappedview.animate().translationXBy(3000f).setDuration(500);
            player = 0;
            GameFilup[GameTag] = 1;
        }

        for (int[] gamestate : winnerposition) {
            if (GameFilup[gamestate[0]] == GameFilup[gamestate[1]] && GameFilup[gamestate[1]] == GameFilup[gamestate[2]]
                    && GameFilup[gamestate[2]] == GameFilup[gamestate[3]] && GameFilup[gamestate[3]] != 2) {
                if (player == 1)
                    msg = "Black is Winner !";
                if (player == 0)
                    msg = "Blue is Winner !";

                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(msg);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
                linearLayout.setVisibility(View.VISIBLE);
                winner = true;
            }
            if (count==16)
            {
                msg = "Game is Drow !";

                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(msg);
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
                linearLayout.setVisibility(View.VISIBLE);
                winner = true;
            }
        }
    }

    public void Tryagain(View view) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        linearLayout.setVisibility(View.INVISIBLE);

        winner = false;
        player = 0;

        for (int i = 0; i < GameFilup.length; i++)
            GameFilup[i] = 2;

        ImageView imageView0= (ImageView) findViewById(R.id.imageView0);
        imageView0.setImageResource(0);
        ImageView imageView1= (ImageView) findViewById(R.id.imageView1);
        imageView1.setImageResource(0);
        ImageView imageView2= (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageResource(0);
        ImageView imageView3= (ImageView) findViewById(R.id.imageView3);
        imageView3.setImageResource(0);
        ImageView imageView4= (ImageView) findViewById(R.id.imageView4);
        imageView4.setImageResource(0);
        ImageView imageView5= (ImageView) findViewById(R.id.imageView5);
        imageView5.setImageResource(0);
        ImageView imageView6= (ImageView) findViewById(R.id.imageView6);
        imageView6.setImageResource(0);
        ImageView imageView7= (ImageView) findViewById(R.id.imageView7);
        imageView7.setImageResource(0);
        ImageView imageView8= (ImageView) findViewById(R.id.imageView8);
        imageView8.setImageResource(0);
        ImageView imageView9= (ImageView) findViewById(R.id.imageView9);
        imageView9.setImageResource(0);
        ImageView imageView10= (ImageView) findViewById(R.id.imageView10);
        imageView10.setImageResource(0);
        ImageView imageView11= (ImageView) findViewById(R.id.imageView11);
        imageView11.setImageResource(0);
        ImageView imageView12= (ImageView) findViewById(R.id.imageView12);
        imageView12.setImageResource(0);
        ImageView imageView13= (ImageView) findViewById(R.id.imageView13);
        imageView13.setImageResource(0);
        ImageView imageView14= (ImageView) findViewById(R.id.imageView14);
        imageView14.setImageResource(0);
        ImageView imageView15= (ImageView) findViewById(R.id.imageView15);
        imageView15.setImageResource(0);

        count=0;

    }

    public void GameStart(View view)
    {
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linearlayout2);
        linearLayout2.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        linearLayout.setVisibility(View.INVISIBLE);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
