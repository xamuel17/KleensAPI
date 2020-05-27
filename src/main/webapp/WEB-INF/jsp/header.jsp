
<nav class="navbar navbar-inverse" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">KleenRims Admin Portal</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/home">Home</a></li>
      <li><a href="#">Orders</a></li>
      <li><a href="/staffs">Staffs</a></li>
       <li><a href="/customers">Customers</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
       <li><h4 class="wel"> Welcome, ${uname} </h4></li>
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Add Admin</a></li>
      <li><a href="/"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
    </ul>
    <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search Order with Booking Code">
      </div>
      <button type="submit" class="btn btn-default">Search</button>
    </form>
  </div>
</nav>

		<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>