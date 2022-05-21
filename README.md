# library-management-system
图书馆管理系统





---

![image-20220521195148147](https://cdn.jsdelivr.net/gh/yub4by/picgobase@main/img/image-20220521195148147.png)

![image-20220521195159047](https://cdn.jsdelivr.net/gh/yub4by/picgobase@main/img/image-20220521195159047.png)



---



1 登陆功能
     1 建表
     2 登陆页面
     3 获取数据
     4 去数据库查数据
     5 跳转
     
2 主页面
     1 设置窗体属性
     2 创建左侧导航JPanel , --->  LeftPanel
          创建三个按钮，设置样式
          
     3 把左侧导航加入主窗体 Main_Frame 中，设置位置 BorderLayout.WEST
     4 创建中间内容容器   ----> CenterPanel
           加了一个图片
           
     5 把中间内容容器加入主窗体 Main_Frame 中，设置位置 BorderLayout.CENTER

3 左侧导航
     给按钮添加点击事件
        1 创建 BookSwingUtil 工具类 获得 Main_Frame 对象
        2 左侧第一个按钮
             点击事件：  根据获得的Main_Frame对象，得到 CenterPanel
                         删除 CenterPanel 中的所有组件
                         重新添加组件，并且按边界布局到中间位置：
                            创建 BookManagerPanel ，UserManagerPanel ，BorrowManagerPanel 容器
                         验证组件是否好使，并且重绘 CenterPanel
        3 其他按钮同上

4 BookManagerPanel 
     1 创建 表格 private JTable table;
     2 在构造方法里 创建表格实例，取消默认布局
     3 获得表中的数据：
          1 创建 BookInfo ，创建 BookDao
          2 创建 JTable 模型  createDefaultModel()
          3 获得数据  getBookData(JTable table)
     4 添加 滚动面板，把表格添加到面板中    
     
     	//创建表格模型
    		public DefaultTableModel createDeFaultModel(){
    			String [] trow = new String[5];
    			trow[0] = "图书编号";
    			trow[1] = "图书名称";
    			trow[2] = "图书作者";	
    			trow[3] = "图书存量";	
    			trow[4] = "图书备注";	
    			
    			DefaultTableModel dt = new DefaultTableModel(trow,0);
    			return dt;
    		}
    		
    		//获得图书全部数据显示表格中
    		private void getBookData(JTable table) {
    			DefaultTableModel dtm = createDeFaultModel();
    			List<BookInfo> bookList = new BookDao().getListBook();
    			for(BookInfo book :bookList){
    				String [] data = new String[5];
    				data[0] = book.getBookId()+"";
    				data[1] =book.getBookName();
    				data[2] =book.getBookAuthor();
    				data[3] =book.getBookNum()+"";
    				data[4] =book.getBookNote();
    				dtm.addRow(data);
    			}
    			table.setModel(dtm);
    		}     


5 增加书籍
    1 创建添加书籍的窗体  BookAdd ，并且 画界面
    2 创建 BookDao中的添加书籍方法
    3 保存按钮事件：
       		btnSave.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							book = new BookInfo();
							book.setBookName(bookName.getText());
							book.setBookAuthor(bookAuthor.getText());
							String strNum = bookNum.getText();
							if(strNum ==null || "".equals(strNum)){
								JOptionPane.showMessageDialog(null, "书籍存量不正确");
							}else{
								book.setBookNum(Integer.parseInt(strNum));
								book.setBookNote(bookNote.getText());
								book.setBookState("可借");
								int result = dao.addBook(book);
								if(result >0 ){
									JOptionPane.showMessageDialog(null, "添加成功");
									dispose();  //关闭界面
									
									JTable table = BookManagerPanel.getTable();
									new BookManagerPanel().getBookData(table);


​									
								}else{
									JOptionPane.showMessageDialog(null, "添加失败");
								}
							}
						}
					});
	4 更新原表格数据

6 修改数据
     1  给修改按钮添加事件， 获取要修改书籍的数据，获取书籍id
     2  根据id查询书籍 
     3  把 id 传到 修改书籍界面，  获取书籍数据进行修改书籍
     
     //修改按钮事件
     btnUpdateBook.addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			int [] index = table.getSelectedRows();
    			if(index.length == 0){
    				JOptionPane.showMessageDialog(null, "请选择要修改的书籍");
    			}else if(index.length > 1){
    				JOptionPane.showMessageDialog(null, "请选择一条数据修改");
    			}else{
    				String strId = (String)table.getValueAt(index[0], 0);
    				int bookId = Integer.parseInt(strId);  //将String类型转成数值型
    				new BookUpdate(bookId);
    			}
    		}
    	}); 
            
    BookManagerPanel:
        用到了 单例模式
          将构造函数私有化，防止别人创建本类实例
          
        	private static BookManagerPanel bookManagerPanel=new BookManagerPanel();
    
    				public static BookManagerPanel getInstence(){   //单例模式
    					return bookManagerPanel;
    				}  
    				
    			  private BookManagerPanel(){....}   //私有化构造函数               

7 删除数据
    1 获取要删除的数据的id ，拼成字符串
    2 创建dao中的方法   
    3 sql=“delete from bookinfo where bookid in () ” 
    4 删除数据 
    
  btnDelBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index [] = table.getSelectedRows();
				if(index.length ==0){
					JOptionPane.showMessageDialog(null, "请选择数据");
				}else{
					String strBookId = "";
					for(int i = 0 ;i<index.length ;i++){
						if(i == index.length-1){
							strBookId += table.getValueAt(index[i], 0);
						}else{
							strBookId += table.getValueAt(index[i], 0)+ ",";
						}
					}
					int result =new BookDao().delBook(strBookId);
					if(result > 0 ){
						JOptionPane.showMessageDialog(null, "删除成功");
					}else{
						JOptionPane.showMessageDialog(null, "删除成功");
					}
					//刷新当前表格
					getBookData(table);
				}
			}
		});

8 模糊查询
		获取前台输入的条件数据
		调用dao层中的查询方法，把查询结果显示在表格中
			//模糊查询
	public List<BookInfo> getBookList(String bookName_m, String bookAuthor_m) {
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		BookInfo book = null;
		List<BookInfo> list = new ArrayList<BookInfo>();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from bookinfo where 1=1 ";
			if(!(bookName_m == null || "".equals(bookName_m))){
				sql += " and bookName  like '%"+bookName_m+"%'";
			}
			if(!(bookAuthor_m ==null || "".equals(bookAuthor_m))){
				sql += " and bookAuthor like '%"+bookAuthor_m+"%' ";
			}
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			System.out.println(sql);
			while(rs.next()){
				book = new BookInfo();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuthor(rs.getString("bookAuthor"));
				book.setBookNum(rs.getInt("bookNum"));
				book.setBookState(rs.getString("bookState"));
				book.setBookNote(rs.getString("bookNote"));
				list.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(conn, stm, rs);
		}
		return list;
	}

借阅管理模块
 1 创建借阅模块主页面
 2 借阅登记的按钮：
    1 获取 userID 和 bookId  ,根据 id 获取 书籍和用户 信息
    2 判断书籍存量是否为0，判断可借还是不借
    3 每本书籍只能借一本，所以判断借阅记录是否有相关数据
    4 借书添加借阅记录
         1 添加
         2 修改图书存量
         3 判断存量是否为0 ，修改图书状态
      

 3 图书查询按钮：
    1 创建根据图书名称查询书籍的页面
    2 查询出来的书籍信息显示在新的窗口
    
 4 借阅查询按钮：
    1 创建根据用户id查询借阅书籍的页面
    2 展示根据用户id查询出来的数据在新的页面

 5 还书登记：
    1 获取图书id 和 用户id
    2 删除相关借阅记录
    3 修改图书存量
    4 判断并且改变图书状态

 6 测试文件夹：
     1 上面数据库中的表BorrowBookInfo 有数据冗余，可以重新设计表，字段 id，userID，bookID，lendTime，sreturnTime
     2 查询某个用户的借阅情况
         select bookinfo.bookName ,t.lendTime,t.sreturnTime from bookinfo join t on t.bookid = bookinfo.bookid where userid = 2
         
     3 把上面查询出来的语句显示在页面中的表格里
     4 在页面加上统计按钮
     5 给按钮添加事件：统计借阅书籍的数据

 

 