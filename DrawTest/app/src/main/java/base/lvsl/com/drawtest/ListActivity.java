package base.lvsl.com.drawtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private static final String TAG = "lvsl";

    private ListView listView;// 主界面上的list展示
    private TextView nameText, ageText;// item的数据展示

    private BaseAdapter adapter;// 加载数据使用的适配器
    private List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_list);

        initView();// 准备控件
        initData();// 准备数据
    }

    private void initView() {
        listView = findViewById(R.id.listview_bai);
    }

    private void initData() {
        // 依次将数据添加到item中,再显示到list上
        for (int i = 0; i < 10; i++) {
            User user = new User();// 自己写的实体类
            user.setName("梅球王" + i);// 设置数据
            user.setAge("24");

            userList.add(user);// 数据添加到list中
        }

        // 准备适配器
        adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return userList.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                // 列表中对应该条数据的id
                return 0;
            }

            /**
             * 设置view,主要在这里
             * getView获取的数据
             * adapter会自动赋给ListView
             * @param position
             * @param convertView
             * @param parent
             * @return
             */
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = ListActivity.this.getLayoutInflater();
                View view;

                if (convertView == null) {// 初始view为空就去新建
                    view = inflater.inflate(R.layout.item, null);
                } else {
                    view = convertView;
                }
                nameText = view.findViewById(R.id.Textviewname);
                ageText = view.findViewById(R.id.Textviewage);
                nameText.setText(userList.get(position).getName());
                ageText.setText(userList.get(position).getAge());

                return view;
            }
        };
        listView.setAdapter(adapter);// 到这一步数据就加载完毕

        // 点击事件展示数据  即点击哪行就显示哪行数据
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nameText = view.findViewById(R.id.Textviewname);
                String name = nameText.getText().toString();// 获取到数据
                Toast.makeText(ListActivity.this, "当前姓名是:" + name, Toast.LENGTH_SHORT).show();
            }
        });
    }



    // 数据实体类   实现Getter和Setter方法,用于数据获取
    class User {
        String name;
        String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
