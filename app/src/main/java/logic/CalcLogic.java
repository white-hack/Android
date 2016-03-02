package logic;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.test1android.R;

import activity.MainActivity;

/**
 * Created by on 2016/03/01.
 */
public class CalcLogic {
    public void calc(MainActivity mainActivity) {
        // オブジェクトを取得
//        EditText etxtNum     = (EditText)mainActivity.findViewById(R.id.etxtNum);
//        EditText etxtMoney   = (EditText)mainActivity.findViewById(R.id.etxtMoney);
        EditText edit1   = (EditText)mainActivity.findViewById(R.id.editText);
        EditText edit2 = (EditText)mainActivity.findViewById(R.id.editText2);
        TextView view1 = (TextView)mainActivity.findViewById(R.id.resultView);

        // 入力内容を取得
        String strNum   = edit1.getText().toString();
        String strMoney = edit2.getText().toString();

        // 数値に変換
        int num   = Integer.parseInt(strNum);
        int money = Integer.parseInt(strMoney);

        // 足し算計算
        int result = money + num;

        // 結果表示用テキストに設定
        view1.setText(Integer.toString(result));

        // 結果表示用テキストを表示
        view1.setVisibility(View.VISIBLE);
    }
}
