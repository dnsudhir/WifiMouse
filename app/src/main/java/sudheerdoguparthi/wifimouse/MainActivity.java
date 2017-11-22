package sudheerdoguparthi.wifimouse;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements KeyEvent.Callback {

  private static final String TAG = "Remote";
  private Button leftClick, rightClick;
  private View touchpad;
  private ImageButton keypadButton;

  private boolean isConnected = false;
  private boolean mouseMoved = false;
  private boolean isCapsOn = false;
  private Socket socket;
  private PrintWriter out;

  private float initX = 0;
  private float initY = 0;
  private float disX = 0;
  private float disY = 0;

  private GestureDetectorCompat gestureDetectorCompat;

  @Override public boolean onKeyUp(int keyCode, KeyEvent event) {

    Log.d(TAG, String.valueOf(keyCode));
    if (isConnected) {

      switch (keyCode) {

        case KeyEvent.KEYCODE_A:

          if (event.isShiftPressed()) {
            out.println("A");
          } else {
            out.println("a");
          }
          break;

        case KeyEvent.KEYCODE_B:
          if (event.isShiftPressed()) {
            out.println("B");
          } else {
            out.println("b");
          }
          break;

        case KeyEvent.KEYCODE_C:
          if (event.isShiftPressed()) {
            out.println("C");
          } else {
            out.println("c");
          }
          break;

        case KeyEvent.KEYCODE_D:
          if (event.isShiftPressed()) {
            out.println("D");
          } else {
            out.println("d");
          }
          break;

        case KeyEvent.KEYCODE_E:
          if (event.isShiftPressed()) {
            out.println("E");
          } else {
            out.println("e");
          }
          break;

        case KeyEvent.KEYCODE_F:
          if (event.isShiftPressed()) {
            out.println("F");
          } else {
            out.println("f");
          }
          break;

        case KeyEvent.KEYCODE_G:
          if (event.isShiftPressed()) {
            out.println("G");
          } else {
            out.println("g");
          }
          break;

        case KeyEvent.KEYCODE_H:
          if (event.isShiftPressed()) {
            out.println("H");
          } else {
            out.println("h");
          }
          break;

        case KeyEvent.KEYCODE_I:
          if (event.isShiftPressed()) {
            out.println("I");
          } else {
            out.println("i");
          }
          break;

        case KeyEvent.KEYCODE_J:
          if (event.isShiftPressed()) {
            out.println("J");
          } else {
            out.println("j");
          }
          break;

        case KeyEvent.KEYCODE_K:
          if (event.isShiftPressed()) {
            out.println("K");
          } else {
            out.println("k");
          }
          break;

        case KeyEvent.KEYCODE_L:
          if (event.isShiftPressed()) {
            out.println("L");
          } else {
            out.println("l");
          }
          break;

        case KeyEvent.KEYCODE_M:
          if (event.isShiftPressed()) {
            out.println("M");
          } else {
            out.println("m");
          }
          break;

        case KeyEvent.KEYCODE_N:
          if (event.isShiftPressed()) {
            out.println("N");
          } else {
            out.println("n");
          }
          break;

        case KeyEvent.KEYCODE_O:
          if (event.isShiftPressed()) {
            out.println("O");
          } else {
            out.println("o");
          }
          break;

        case KeyEvent.KEYCODE_P:
          if (event.isShiftPressed()) {
            out.println("P");
          } else {
            out.println("p");
          }
          break;

        case KeyEvent.KEYCODE_Q:
          if (event.isShiftPressed()) {
            out.println("Q");
          } else {
            out.println("q");
          }
          break;

        case KeyEvent.KEYCODE_R:
          if (event.isShiftPressed()) {
            out.println("R");
          } else {
            out.println("r");
          }
          break;

        case KeyEvent.KEYCODE_S:
          if (event.isShiftPressed()) {
            out.println("S");
          } else {
            out.println("s");
          }
          break;

        case KeyEvent.KEYCODE_T:
          if (event.isShiftPressed()) {
            out.println("T");
          } else {
            out.println("t");
          }
          break;

        case KeyEvent.KEYCODE_U:
          if (event.isShiftPressed()) {
            out.println("U");
          } else {
            out.println("u");
          }
          break;

        case KeyEvent.KEYCODE_V:
          if (event.isShiftPressed()) {
            out.println("V");
          } else {
            out.println("v");
          }
          break;

        case KeyEvent.KEYCODE_W:
          if (event.isShiftPressed()) {
            out.println("W");
          } else {
            out.println("w");
          }
          break;

        case KeyEvent.KEYCODE_X:
          if (event.isShiftPressed()) {
            out.println("X");
          } else {
            out.println("x");
          }
          break;

        case KeyEvent.KEYCODE_Y:
          if (event.isShiftPressed()) {
            out.println("Y");
          } else {
            out.println("y");
          }
          break;

        case KeyEvent.KEYCODE_Z:
          if (event.isShiftPressed()) {
            out.println("Z");
          } else {
            out.println("z");
          }
          break;

        case KeyEvent.KEYCODE_DEL:
          out.println("backspace");
          break;

        case KeyEvent.KEYCODE_SPACE:
          out.println("space");
          break;

        case KeyEvent.KEYCODE_0:
          out.println("0");
          break;

        case KeyEvent.KEYCODE_1:
          out.println("1");
          break;

        case KeyEvent.KEYCODE_2:
          out.println("2");
          break;

        case KeyEvent.KEYCODE_3:
          out.println("3");
          break;

        case KeyEvent.KEYCODE_4:
          out.println("4");
          break;

        case KeyEvent.KEYCODE_5:
          out.println("5");
          break;

        case KeyEvent.KEYCODE_6:
          out.println("6");
          break;

        case KeyEvent.KEYCODE_7:
          out.println("7");
          break;

        case KeyEvent.KEYCODE_8:
          out.println("8");
          break;

        case KeyEvent.KEYCODE_9:
          out.println("9");
          break;

        case KeyEvent.KEYCODE_AT:
          out.println("@");
          Log.d(TAG, "At");
          break;

        case KeyEvent.KEYCODE_SEMICOLON:
          out.println(";");
          break;

        case KeyEvent.KEYCODE_BACKSLASH:
          out.println("backslash");
          break;

        case KeyEvent.KEYCODE_COMMA:
          out.println("comma");
          break;

        case KeyEvent.KEYCODE_ENTER:
          out.println("enter");
          break;

        case KeyEvent.KEYCODE_EQUALS:
          out.println("=");
          break;

        case KeyEvent.KEYCODE_SLASH:
          out.println("/");
          break;

        case KeyEvent.KEYCODE_STAR:
          out.println("*");
          break;

        case KeyEvent.KEYCODE_RIGHT_BRACKET:
          out.println(")");
          break;

        case KeyEvent.KEYCODE_LEFT_BRACKET:
          out.println("(");
          break;
      }
    }

    return super.onKeyUp(keyCode, event);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    leftClick = (Button) findViewById(R.id.btnLeftClick);
    rightClick = (Button) findViewById(R.id.btnRightClick);
    keypadButton = (ImageButton) findViewById(R.id.keypadimgbtn);
    touchpad = findViewById(R.id.touchPad);

    gestureDetectorCompat =
        new GestureDetectorCompat(this, new GestureDetector.OnGestureListener() {
          @Override public boolean onDown(MotionEvent e) {
            return false;
          }

          @Override public void onShowPress(MotionEvent e) {

          }

          @Override public boolean onSingleTapUp(MotionEvent e) {
            return false;
          }

          @Override public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
              float distanceY) {
            return false;
          }

          @Override public void onLongPress(MotionEvent e) {

          }

          @Override
          public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
          }
        });

    gestureDetectorCompat.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
      @Override public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
      }

      @Override public boolean onDoubleTap(MotionEvent e) {

        if (isConnected && out != null) {
          out.println(Constants.MOUSE_DOUBLE_TAP);
        } else {
          Toast.makeText(MainActivity.this, "Server Not Connected", Toast.LENGTH_SHORT).show();
        }

        return true;
      }

      @Override public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
      }
    });

    leftClick.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        if (isConnected && out != null) {

          out.println(Constants.MOUSE_LEFT_CLICK);
        } else {
          Toast.makeText(MainActivity.this, "Server Not Connected", Toast.LENGTH_SHORT).show();
        }
      }
    });

    rightClick.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        if (isConnected && out != null) {

          out.println(Constants.MOUSE_RIGHT_CLICK);
        } else {
          Toast.makeText(MainActivity.this, "Server Not Connected", Toast.LENGTH_SHORT).show();
        }
      }
    });

    keypadButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        if (isConnected) {

          InputMethodManager imm =
              (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
          imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        } else {
          Toast.makeText(MainActivity.this, "Server Not Connected", Toast.LENGTH_SHORT).show();
        }
      }
    });

    touchpad.setOnTouchListener(new View.OnTouchListener() {
      @Override public boolean onTouch(View v, MotionEvent motionEvent) {

        gestureDetectorCompat.onTouchEvent(motionEvent);

        if (isConnected && out != null) {

          switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN:

              initX = motionEvent.getX();
              initY = motionEvent.getY();

              mouseMoved = false;

              break;

            case MotionEvent.ACTION_MOVE:

              disX = motionEvent.getX() - initX;
              disY = motionEvent.getY() - initY;

              initX = motionEvent.getX();
              initY = motionEvent.getY();

              if (disX != 0 || disY != 0) {

                out.println(disX + "," + disY);
              }

              mouseMoved = true;

              break;

            case MotionEvent.ACTION_UP:

              if (!mouseMoved) {

                out.println(Constants.MOUSE_LEFT_CLICK);
              }
          }
        }

        return true;
      }
    });
  }

  @Override public void onBackPressed() {

    if (!getSupportActionBar().isShowing()) {
      getSupportActionBar().show();
      Settings.System.putInt(MainActivity.this.getContentResolver(), "show_touches", 0);
      if (isConnected && out != null) {

        try {
          out.println("exit");
          out.close();
          socket.close();
          isConnected = false;
        } catch (IOException e) {

          Log.e("RemoteDroid", "Error in Closing Socket", e);
        }
      }
    } else {

      super.onBackPressed();
    }
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {

    getMenuInflater().inflate(R.menu.menu_main, menu);

    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();

    if (id == R.id.action_connect) {

      final EditText editText = new EditText(this);

      AlertDialog.Builder builder = new AlertDialog.Builder(this);

      builder.setTitle("Server IP Address");
      builder.setMessage("Enter Your System IP Address");
      builder.setView(editText);
      builder.setCancelable(false);

      builder.setPositiveButton("Connect", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialogInterface, int i) {

          if (TextUtils.isEmpty(editText.getText().toString().trim())) {

            editText.setError("Please Enter Server IP Address");
            editText.requestFocus();

            Toast.makeText(MainActivity.this, "Please Enter IP Address", Toast.LENGTH_SHORT).show();
          } else {

            editText.setError(null);
            Constants.SERVER_IP = editText.getText().toString().trim();

            ConnectPhoneTask phoneTask = new ConnectPhoneTask();
            phoneTask.execute(Constants.SERVER_IP);

            getSupportActionBar().hide();
          }
        }
      });

      builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override public void onClick(DialogInterface dialog, int which) {

          finish();
        }
      });

      builder.show();

      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override public void onDestroy() {

    Settings.System.putInt(MainActivity.this.getContentResolver(), "show_touches", 0);

    super.onDestroy();

    if (isConnected && out != null) {

      try {
        out.println("exit");
        out.close();
        socket.close();
      } catch (IOException e) {

        Log.e("RemoteDroid", "Error in Closing Socket", e);
      }
    }
  }

  public class ConnectPhoneTask extends AsyncTask<String, Void, Boolean> {

    ProgressDialog progressDialog;

    @Override protected void onPreExecute() {
      super.onPreExecute();

      progressDialog = ProgressDialog.show(MainActivity.this, "Connecting...", "Please Wait...");
    }

    @Override protected Boolean doInBackground(String... strings) {
      boolean result = true;
      try {
        InetAddress serverAddr = InetAddress.getByName(strings[0]);
        socket = new Socket(serverAddr, Constants.SERVER_PORT);
      } catch (IOException e) {
        Log.e("RempteDroid", "Error While Connecting", e);
        result = false;
      }
      return result;
    }

    @Override protected void onPostExecute(Boolean aBoolean) {

      if (progressDialog.isShowing()) progressDialog.dismiss();

      isConnected = aBoolean;
      try {

        if (aBoolean) {

          Settings.System.putInt(MainActivity.this.getContentResolver(), "show_touches", 1);
          Toast.makeText(MainActivity.this,
              aBoolean ? "Connected To Server" : "Error While Connecting", Toast.LENGTH_LONG)
              .show();
          out =
              new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),
                  true);
        } else {

          Toast.makeText(MainActivity.this, "Server Not Found", Toast.LENGTH_SHORT).show();
        }
      } catch (IOException e) {

        Log.e("RemoteDroid", "Error While Creating OutputWriter", e);
        Toast.makeText(MainActivity.this, "Error While Connecting", Toast.LENGTH_SHORT).show();
      }
    }
  }
}
