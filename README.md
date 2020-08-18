#HeaderRecyclerViewDemo

**1、引入依赖** 

在Project的build.gradle在添加以下代码

```
	allprojects {
		repositories {
			...
			  maven { url "https://ewgcat.bintray.com/utils/" }
		}
	}
```
在Module的build.gradle在添加以下代码

```
	    api 'com.lsh.headerrecyclerview:HeaderRecyclerView:+'

```

**2、使用** 
你需要自己包装HeaderViewAdapter，并且用HeaderViewAdapter给列表添加头部和尾部。它可以包装所有的RecyclerView Adapter和适用于所有的RecyclerView。
```java
	//需要包装的adapter
        LinearAdapter adapter = new LinearAdapter(this);
	
        //对adapter进行包装。
        HeaderViewAdapter headerViewAdapter = new HeaderViewAdapter(adapter);
	
	//添加HeaderView和FooterView
        headerViewAdapter.addHeaderView(headerView);
        headerViewAdapter.addFooterView(footerView);
	
        //设置Adapter
        recyclerView.setAdapter(headerViewAdapter);
```
无论我们的RecyclerView使用什么LayoutManager，HeaderViewAdapter都需要保证列表的头部和尾部能占满一行，否则布局就会很难看。使用LinearLayoutManager的时候不需要做特殊的处理，HeaderViewAdapter也已经帮我们处理了StaggeredGridLayoutManager的情况。至于GridLayoutManager的情况，我在HeaderViewAdapter的库里提供了一个HeaderViewGridLayoutManager的子类。所以大家在使用GridLayoutManager的时候，应该使用HeaderViewGridLayoutManager。
```java
	recyclerView.setLayoutManager(new HeaderViewGridLayoutManager(this, 2, headerViewAdapter));
```
为了让我们的RecyclerView添加头部和尾部的时候，更接近于ListView的体验。所以我在库里提供了一个RecyclerView子类：HeaderRecyclerView。HeaderRecyclerView封装了对HeaderViewAdapter的所以操作，这使我们只需要操作HeaderRecyclerView，而无需直接跟HeaderViewAdapter打交道，这使得我们使用HeaderRecyclerView的时候就如同以前使用ListView一样。
```java
    HeaderRecyclerView rvList = (HeaderRecyclerView) findViewById(R.id.rv_list);
    //这是普通的adapter
    GridAdapter adapter = new GridAdapter(this);
    rvList.setLayoutManager(new GridLayoutManager(this, 2));
    //直接设置普通的adapter，不需要直接进行包装。
    rvList.setAdapter(adapter);

    //添加HeaderView和FooterView。直接操作HeaderRecyclerView。
    rvList.addHeaderView(headerView);
    rvList.addFooterView(footerView);
```
对HeaderViewAdapter的原理讲解和更多的介绍，请关注我的博客文章：[Android 给RecyclerView添加头部和尾部](http://www.jianshu.com/p/45059108f3a7)。谢谢！
