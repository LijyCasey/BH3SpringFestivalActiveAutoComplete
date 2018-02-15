# BH3SpringFestivalActiveAutoComplete

# 用于崩坏3除夕活动

修改ConnectUtils.java里的AuthParam参数 修改为自己的auth_key和sign

直接执行Bin类的main即可

此程序是自动检索低价的物品，然后以较高价格卖出。


# 如何获取auth_key和sign
点击除夕活动，跳转到safari界面时，直接复制当前窗口的链接，应该会看到一大串url:类似于
https://event.bh3.com/bh3_2018spring_festival/index.html?sign=XXXXXXXXXXXXXXXXX&auth_key=XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

直接将？后面的参数复制替换AuthParam的值即可
# 注意，通过上述链接获取的AuthParam需要把auth_key最后的#（井号）去掉，此问题导致无法正确识别auth_key造成未知错误
