<body>

	<div class="row sub-nav-user-info m-0">
        <span class="col-3 w-auto sub-nav-cards"><b>A/c Holder Name:</b>  ${account.user.firstname}  ${account.user.lastname}</span> 
        <span class="col-3 w-auto sub-nav-cards"><b>A/c Number :</b> ${account.accno} </span>
		<span class="col-3 w-auto sub-nav-cards"><b>A/c Type :</b> Savings </span>   
		<span class="col-3 w-auto sub-nav-cards"><b>Balance :</b> Rs.  ${account.balance} </span>
       	<div class="w-auto bell-icon d-flex align-items-center fs-3">
        	<i class="far fa-bell "></i>       
        </div>       
	</div>
</body>