# insomnia

//UNTUK USER

1. Untuk mengetahui informasi semua User
	POSTMan -> GET Method Link : localhost:8080/users

2. Untuk Mengetahui informasi satu User
	POSTMan -> GET Method Link : localhost:8080/users/YOUR USER_NAME HERE

3. Untuk menambah User
	POSTMan -> POST Method Link : localhost:8080/users/register
	Format : 
	{
		"userName" : "YOUR USER NAME HERE",
		"fullName" : "YOUR FULL NAME HERE"
	}

4. Untuk mengupdate data User
	POSTMan -> PUT Method Link : localhost:8080/users/YOUR USER_NAME HERE/update
	Format : 
	{
		"userName" : "YOUR USER NAME HERE",
		"fullName" : "UPDATED FULL NAME HERE"
	}

5. Untuk delete User
	POSTMan -> DELETE Method Link : localhost:8080/users/YOUR USER_NAME HERE/delete


//UNTUK TODO ITEMS

1. Untuk melihat list todo dari satu User
	POSTMan -> GET Method Link : localhost:8080/users/YOUR USER_NAME HERE/todo

2. Untuk menambah todo item
	POSTMan -> POST Method Link : localhost:8080/users/YOUR USER_NAME HERE/todo/insert
	Format
	{
		"itemTitle" : "YOUR TODO TITLE HERE",
		"itemDescription" : "YOUR TODO DESCRIPTION HERE"
	}

3. Untuk mengupdate todo item
	POSTMan -> POST Method Link : localhost:8080/users/YOUR USER_NAME HERE/todo/TODO_ID HERE/update
	Format
	{
		"itemTitle" : "UPDATED TODO TITLE HERE",
		"itemDescription" : "UPDATED TODO DESCRIPTION HERE"
	}

4. Untuk delete todo item
	POSTMan -> POST Method Link : localhost:8080/users/YOUR USER_NAME HERE/todo/TODO_ID HERE/delete
