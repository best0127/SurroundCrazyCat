package ndnu.tdy.CreazyCat.Activity;

import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import ndnu.tdy.CreazyCat.R;
import ndnu.tdy.CreazyCat.View.GameView;


public class ChooseActivity extends AppCompatActivity {

    /**
     * 定义按钮
     */
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    /**
     * 定义行列和随机数
     */
    private int COL;
    private int ROW;
    private int rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        getSupportActionBar().hide();
        setStatusBar();
        Click();
    }

    /**
     * 定义按钮事件
     */
    public void Click(){
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
//        button4 = (Button)findViewById(R.id.button4);

        button1.setOnClickListener(new Listener());
        button2.setOnClickListener(new Listener());
        button3.setOnClickListener(new Listener());
//        button4.setOnClickListener(new Listener());
    }

    /**
     * 定义按钮监听事件进行传值
     */
    public  class Listener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            //模式选择
            switch (view.getId()){
                case R.id.button1:
                    ROW=12;
                    COL=12;
                    rand=5;
                    break;
                case R.id.button2:
                    ROW=9;
                    COL=9;
                    rand=6;
                    break;
                case R.id.button3:
                    ROW=8;
                    COL=8;
                    rand=7;
                    break;
                default:
                    finish();
            }
            GameView gameView = new GameView(ChooseActivity.this,ROW,COL,rand);
            setContentView(gameView);
        }
    }

    /**
     * 隐藏状态栏
     */
    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//隐藏状态栏但不隐藏状态栏字体
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //隐藏状态栏，并且不显示字体
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//实现状态栏文字颜色为暗色

        }
    }


    /**
     * 返回结束进程
     */
/*    private static final int TIME_EXIT=2000;
    private long mBackPressed;

    @Override
    public void onBackPressed(){                                    //onBackPressed()   捕获后退键按钮back的信息
        if(mBackPressed+TIME_EXIT>System.currentTimeMillis()){      //currentTimeMillis,返回毫秒级别的系统时间
            super.onBackPressed();
            return;
        }else{
            Toast.makeText(this,"再点击一次返回退出程序", Toast.LENGTH_SHORT
            ).show();
            mBackPressed=System.currentTimeMillis();
        }
    }*/
}