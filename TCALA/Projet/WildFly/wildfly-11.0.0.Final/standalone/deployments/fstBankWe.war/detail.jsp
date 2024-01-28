<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    FST_BANK
  </title>
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
  <!-- CSS Files -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
  <link href="assets/css/paper-dashboard.css?v=2.0.0" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="assets/demo/demo.css" rel="stylesheet" />
</head>
<body>
<div class="wrapper ">
	   
<div class="sidebar" data-color="white" data-active-color="danger">
    
      <div class="logo">
        <a href="./login_client_bank.do" class="simple-text logo-mini">
          <div class="logo-image-small">
            <img src="assets/img/logo-small.png">
          </div>
        </a>
        <a class="simple-text logo-normal">
          FST_BANK
          <!-- <div class="logo-image-big">
            <img src="assets/img/logo-big.png">
          </div> -->
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          
          <li class="active">
            <a href="./AssocierCompteBnq">
              <i class="nc-icon nc-tile-56"></i>
              <p>Associer</p>
            </a>
          </li>
          <li >
            <a href="./CompteBanquierServelet">
              <i class="nc-icon nc-single-02"></i>
              <p>Comptes</p>
            </a>
          </li>
          
          
        </ul>
      </div>
    </div>
    
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <div class="navbar-toggle">
              <button type="button" class="navbar-toggler">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </button>
            </div>
            <a class="navbar-brand" href="#pablo">
					
				   
					<label>${banquier.getNom()} ${banquier.getPrenom()}</label>
				
			
			 </a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="navigation">
            
            <ul class="navbar-nav">
              
              <li class="nav-item btn-rotate dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="nc-icon nc-settings-gear-65"></i>
                  <p>
                   <span class="d-lg-none d-md-block">Account</span>
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                  
                  <a class="dropdown-item">
                  		<form action="login_client_bank.do" method="post">
							<input type="submit" name="action" value="logout" class="form-control">
						</form>
				  </a>
                </div>
              </li>
              
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
      <!-- <div class="panel-header panel-header-sm">


</div> -->
      
   
      
      
      <div class="content">
        <div class="row">
        <div class="col-md-12">
            <div class="card card-user">
              <div class="card-header">
                <h5 class="card-title">D�tail du compte</h5>
              </div>
               </div>
                </div>
              
      
          <div class="col-md-12">
            <div class="card card-user">
              <div class="card-header">
              <div class="row">
                    <div class="col-md-6 pr-1">
                <h5 class="card-title">Clients</h5>
                </div>
                    
 
                   
                </div>
              </div>
              <div class="card-body">
              
            
              <div id="compte_non_ex">
             
           
                 
                  <div class="row">
                    <div class="col-md-6 pr-1">
                      <div class="form-group">
                        <label>Code :</label>
                       <h5></h5>
                      </div>
                    </div>
                    <div class="col-md-6 pl-1">
                      <div class="form-group">
                        <label>Solde :</label>
                         <h5></h5>
                      </div>
                    </div>
                  </div>
                 
                  
                  <div class="row">
                    <div class="col-md-12 pr-1">
                      <div class="form-group">
                        <label>Type :</label>   
                      </div>
                    </div>
                    </div>
                    <div class="row">
                      
                    <div class="col-md-6 ">
                            <div class="row">
                            <div class="col-md-2 ">
                      <div class="form-group">
                         <h5></h5>
                      </div>
                      </div>
                      <div class="col-md-8 ">
                              <div class="form-group">
                      <p>Professionel</p>
                     </div>
                     </div>
                      
                      </div>
                      </div>
                            <div class="col-md-6 ">
                            <div class="row">
                            <div class="col-md-2 ">
                      <div class="form-group">
                         <input type ="radio" class="form-control" name="type" value="2" onchange="changerType(this.value)">
                      </div>
                      </div>
                      <div class="col-md-8 ">
                              <div class="form-group">
                      <p>Particulier</p>
                     </div>
                     </div>
                      
                      </div>
                      </div>
                    </div>
                  
                  <div class="row">
                      
                    <div class="col-md-6 " style="display:none" id="registre">
                           
                      <div class="form-group">
                      <label>Registre comercial</label>
                         <input type ="text" class="form-control" name="registre" value="" >
                      </div>
                      
                      </div>
                            <div class="col-md-6 " style="display:none" id="p&p">
                            <div class="row">
                            <div class="col-md-2 ">
                      <div class="form-group">
                      
                         <input type ="radio" class="form-control" name="typecc" value="1">
                      </div>
                      </div>
                      <div class="col-md-4 ">
                              <div class="form-group">
                      <p>Partag�</p>
                     </div>
                     </div>
                            <div class="col-md-2 ">
                      <div class="form-group">
                      
                         <input type ="radio" class="form-control" name="typecc" value="2">
                      </div>
                      </div>
                      <div class="col-md-4 ">
                              <div class="form-group">
                      <p>Priv�</p>
                     </div>
                     </div>
                      </div>
                      </div>
                    </div>
                 
           
                 
           
                 </div>
              </div>
            </div>
          </div>
          
                <div class="col-md-12">
            <div class="card card-user">
              <div class="card-header">
                  <div class="row">
                    <div class="col-md-6 pr-1">
                <h5 class="card-title">Clients</h5>
                </div>
               
                    <div class="col-md-6 pr-1">
                  <div class="form-group">
                        <label>Clients :</label>
                         <select class="form-control" name="client" onchange="changer_client(this.value)">
							  
							  		<option value="2">Nouveau</option>
							  		<option value="1">Existe D�j�</option>
						
						</select> 
                      </div>
                      </div>
                </div>
              </div>
              <div class="card-body">
               <div class="row">
               <h5 style="color:red"> ${errorEx1}</h5>
               </div>
                       <div id="client_ex" style="display:none">
             <div class="row">
             <div class="col-md-2" ></div>
                    <div class="col-md-8 pr-1">
                      <div class="form-group">
                        <label>Clients :</label>
                          
						<select class="form-control" name="client_id" multiple >
						<c:forEach items="${clients}" var="client">
                          <option value='<c:out value="${client.getId()}"></c:out>'>${client.getNom()} ${client.getPrenom()}</option>
                          </c:forEach>
						</select> 
                      </div>
                    </div>
                    
                    <div class="col-md-2" ></div> 
                  </div>  
              </div>
                  <div id="client_non_ex" >
                  <div class="row">
                    <div class="col-md-6 pr-1">
                      <div class="form-group">
                        <label>Nom :</label>
                        <input type="text" name="nom"  class="form-control" placeholder="Nom" >
                      </div>
                    </div>
                 
                  </div>
                  <div class="row">
                    <div class="col-md-6 pr-1">
                      <div class="form-group">
                        <label>Prenom :</label>
                        <input type="text" name="prenom"  class="form-control" placeholder="Prenom" >
                      </div>
                    </div>
                    
                  </div>
                  
                </div>
              </div>
            </div>
          </div>
           <div class="col-md-12">
            <div class="card card-user">
              <div class="card-header">
               
                  <div class="row">
                    <div class="update ml-auto mr-auto">
                      <button type="submit" class="btn btn-primary btn-round">Associer</button>
                    </div>
                  </div>
              </div>
               </div>
                </div>
          </form> 
        </div>
      </div>
      
      
      <footer class="footer footer-black  footer-white ">
        <div class="container-fluid">
          <div class="row">
            <nav class="footer-nav">
              
            </nav>
            
          </div>
        </div>
      </footer>
    </div>
    
    
    
</div>

<!--   Core JS Files   -->
  <script src="assets/js/core/jquery.min.js"></script>
  <script src="assets/js/core/popper.min.js"></script>
  <script src="assets/js/core/bootstrap.min.js"></script>
  <script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <!--  Google Maps Plugin    -->
  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
  <!-- Chart JS -->
  <script src="assets/js/plugins/chartjs.min.js"></script>
  <!--  Notifications Plugin    -->
  <script src="assets/js/plugins/bootstrap-notify.js"></script>
  <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="assets/js/paper-dashboard.min.js?v=2.0.0" type="text/javascript"></script>
  <!-- Paper Dashboard DEMO methods, don't include it in your project! -->
  <script src="assets/demo/demo.js"></script>
</body>
</html>