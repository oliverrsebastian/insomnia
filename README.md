# spring-todo-list

//UNTUK USER

1. Untuk Mengetahui Informasi User
	POSTMan -> GET Method Link : localhost:8080/user/YOUR USER_NAME HERE

2. Untuk menambah User
	POSTMan -> POST Method Link : localhost:8080/user/register
	Format : 
	{
		"userName" : "YOUR USER NAME HERE",
		"fullName" : "YOUR FULL NAME HERE"
	}

3. Untuk mengupdate data User
	POSTMan -> PUT Method Link : localhost:8080/user/YOUR USER_NAME HERE/update
	Format : 
	{
		"userName" : "UPDATED USER NAME HERE",
		"fullName" : "UPDATED FULL NAME HERE"
	}

4. Untuk delete User
	POSTMan -> DELETE Method Link : localhost:8080/user/YOUR USER_NAME HERE/delete


//UNTUK TODO ITEMS

1. Untuk melihat list todo dari satu User
	POSTMan -> GET Method Link : localhost:8080/user/YOUR USER_NAME HERE/todo

2. Untuk menambah todo item
	POSTMan -> POST Method Link : localhost:8080/user/YOUR USER_NAME HERE/todo/insert
	Format
	{
		"itemDescription" : "YOUR TODO HERE"
	}

3. Untuk mengupdate todo item
	POSTMan -> POST Method Link : localhost:8080/user/YOUR USER_NAME HERE/todo/TODO_ID HERE/update
	Format
	{
		"itemDescription" : "UPDATED TODO HERE"
	}

4. Untuk delete todo item
	POSTMan -> POST Method Link : localhost:8080/user/YOUR USER_NAME HERE/todo/TODO_ID HERE/delete
