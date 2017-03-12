# XXPhotoView 使用方式
##  添加依赖
1.在project目录的build.gradle的allprojects节点添加
```java maven { url "https://jitpack.io" }```
如下:
```java
    allprojects {
        repositories {
            jcenter()
            maven { url "https://jitpack.io" }
        }
    }
```
2.在自己Modul的build.gradle中添加```java compile 'com.github.lshGitHubName:XXPhotoView:v1.0.0'```
如下:
```java
dependencies {
	        compile 'com.github.lshGitHubName:XXPhotoView:v1.0.0'
	}
```

3 假如你想用项目中的ImgActivity(一个显示一个图片的Activity) 或者ViewPagerActivity(一个用viewpager来显示多张图片的Activity)
你还需要做以下的:
在Manifest中加上如下代码:
```java
<activity android:name="com.luoshihai.xxphotoview.ImgActivity"/>
<activity android:name="com.luoshihai.xxphotoview.ViewPagerActivity"/>
```
4 由于项目依赖了```'com.github.bumptech.glide:glide:3.7.0'```请根据需要exclude

## 开始使用
1.在布局中写上:
```java
<com.luoshihai.xxphotoview.PhotoView
        android:id="@+id/img1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />
 ```
2.java代码:
```java
PhotoView photoView = (PhotoView) findViewById(R.id.img);
// 启用图片缩放功能
photoView.enable();
// 禁用图片缩放功能 (默认为禁用，会跟普通的ImageView一样，缩放功能需手动调用enable()启用)
photoView.disenable();
// 获取图片信息
Info info = photoView.getInfo();
// 从一张图片信息变化到现在的图片，用于图片点击后放大浏览
photoView.animaFrom(info);
// 从现在的图片变化到所给定的图片信息，用于图片放大后点击缩小到原来的位置，具体使用可以参照demo的使用
photoView.animaTo(info,new Runnable() {
       @Override
       public void run() {
           //动画完成监听
       }
   });
// 获取动画持续时间
int d = PhotoView.getDefaultAnimaDuring();

//是否允许图片旋转
photoView.setAllowRotate(isallowRotate);
//设置点击回调
photoView.setOnSinglClick(onSinglClick);
```

3.如果想用library的ImgActivity
```java
  Intent intent = new Intent(this, ImgActivity.class);
        intent.putExtra("url", "http://pic55.nipic.com/file/20141208/19462408_171130083000_2.jpg");
        intent.putExtra("isallowRotate", true);//是否允许图片旋转
        startActivity(intent);
 ````
4.如果想用library的ViewPagerActivity
```java
 ArrayList<String> mdatas = new ArrayList<>();
        mdatas.add("http://pic55.nipic.com/file/20141208/19462408_171130083000_2.jpg");
        mdatas.add("http://img3.imgtn.bdimg.com/it/u=17572568,2472534097&fm=23&gp=0.jpg");
        mdatas.add("http://img0.imgtn.bdimg.com/it/u=1881341853,2194594401&fm=23&gp=0.jpg");
        mdatas.add("http://img1.imgtn.bdimg.com/it/u=2180892042,1064845699&fm=23&gp=0.jpg");
        Intent intent = new Intent(this, ViewPagerActivity.class);
        intent.putExtra("position", 0);//默认显示第几张图片
        intent.putExtra("mDatas", mdatas);
        startActivity(intent);
 ```