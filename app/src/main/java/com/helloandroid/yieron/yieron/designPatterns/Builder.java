package com.helloandroid.yieron.yieron.designPatterns;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.helloandroid.yieron.yieron.R;

/**
 * 作者：yindong on 2017/2/24.
 * 邮箱：yieron@163.com
 * 版本：v1.0
 */
public class Builder {
    /**
     * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
     * 模式的使用场景：
     * 相同的方法，不同的执行顺序，产生不同的事件结果时；
     * 多个部件或零件，都可以装配到一个对象中，但是产生的运行结果又不相同时；
     * 产品类非常复杂，或者产品类中的调用顺序不同产生了不同的效能，这个时候使用建造者模式非常合适；
     * <p>
     * 优点：
     * 良好的封装性， 使用建造者模式可以使客户端不必知道产品内部组成的细节；
     * 建造者独立，容易扩展；
     * 在对象创建过程中会使用到系统中的一些其它对象，这些对象在产品对象的创建过程中不易得到。
     * <p>
     * 缺点:
     * 会产生多余的Builder对象以及Director对象，消耗内存；
     * 对象的构建过程暴露。
     */

    //在Android源码中，我们最常用到的Builder模式就是AlertDialog.Builder
    //显示基本的AlertDialog
    private void showDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Title");
        builder.setMessage("Message");
        builder.setPositiveButton("Button1",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        builder.setNeutralButton("Button2",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        builder.setNegativeButton("Button3",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        builder.create().show();  // 构建AlertDialog， 并且显示
    }
}
