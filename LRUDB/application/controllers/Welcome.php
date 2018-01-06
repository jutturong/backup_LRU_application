<?php  session_start(); ?>
<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class Welcome extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see https://codeigniter.com/user_guide/general/urls.html
	 */
    
                     public function __construct() 
                      {
                         parent::__construct();
                         $this->load->database();
                         
                     }
                     
	public function index()
	{
		$this->load->view('welcome_message');
	}
        
        // http://192.168.2.120/LRUDB/index.php/welcome/checklogin
                     public  function  checklogin() // ตรวจสอบการ login เข้าสู่ระบบ
                     {
                           
                              $us=trim($this->input->get_post("us"));
                              $ps=trim($this->input->get_post("ps"));
                              
                              
                              
                            //   $us="login1";
                         //   $ps="login1";
                            
                            
                              $ps= md5($ps);
                              $tb="tb_user";
                              $tbj1="tb_position";
                              $this->db->join($tbj1,$tb.".id_position=".$tbj1.".id_position","left");
                              //username
                              //password
                              
                              $query=$this->db->get_where($tb,array($tb.".username"=>$us,$tb.".password"=>$ps));
                              $row=$query->row();
                               $firstname=$row->firstname;
                             //echo br();
                               $lastname=$row->lastname;
                             //echo br();
                               $username=$row->username;
                            // echo br();
                              $password=$row->password;
                             //echo br();
                              $id_position=$row->id_position;
                             //echo br();
                             $position=$row->position;
                             
                             $data=array(
                                 "sess_login"=>1,
                                 "sess_firstname"=>$firstname,
                                 "sess_lastname"=>$lastname,   
                                 "sess_username"=>$username,
                                 "sess_password"=>$password,
                                 "sess_id_position"=>$id_position,
                                 "sess_position"=>$position    
                             );
                             
                            // print_r($data);
                            echo  json_encode($data);
                               
                     }
                       // http://192.168.2.120/LRUDB/index.php/welcome/json_position/1
                     public function json_position()//เรียกประเภทของการปฏิบัติงาน
                     {
                         
                         // $id_position=trim($this->uri->segment(3));
                          $id_position=trim($this->inut->get_post("id_position"));
                          
                        //echo br();
                           if( $id_position > 0 )
                           {
                                  $tb="tb_position";
                                  $query=$this->db->get_where($tb,array("id_position"=>$id_position));
                                   $num= $query->num_rows();
                                   if( $num > 0 )
                                   {
                                         $row=$query->row();
                                         $position=$row->position;
                                          echo json_encode(array("position"=>$position));
                                   }
                           }
                     }
                        // http://192.168.2.112/LRUDB/index.php/welcome/tb_working
                     public  function tb_working()//กิจกรรมการทำงาน
                     {
                         $id_position=trim($this->input->get_post("id_position"));
                         //$id_position=2;
                         $tb="tb_working";
                               $query=$this->db->get_where($tb,array("id_position"=>$id_position));
                               foreach($query->result() as $row )
                               {
                                   $rows[]=$row;
                               }
                               echo json_encode($rows);
                     }
                     
                     // http://192.168.2.112/LRUDB/index.php/welcome/json_province_backend
                     public  function json_province_backend()
                     {
                           $tb="province";
                         //  $query=$this->db->get_where($tb,array("id_position"=>$id_position));
                           $query=$this->db->get($tb);
                               foreach($query->result() as $row )
                               {
                                   $rows[]=$row;
                               }
                                  echo json_encode($rows);
                           
                     }
                    
                     // http://192.168.2.112/LRUDB/index.php/welcome/uploadfile
                     public function uploadfile()
                     {
                      $file1name = $_FILES['filUpload']['name'];
            	$file1tmp  =$_FILES['filUpload']["tmp_name"]; // tmp folder
           	$file1Type= $_FILES['filUpload']["type"]; //type of file
           	$file1Size= $_FILES['filUpload']["size"]; //size
           	$file1ErrorMsg = $_FILES['filUpload']["error"]; // 0=false 1=true
             	$cp1=copy($file1tmp ,  "uploadfile/". $file1name );
                      
   /*                  
if(@move_uploaded_file($_FILES["filUpload"]["tmp_name"],"uploadfile/".$_FILES["filUpload"]["name"]))
{
	$arr["StatusID"] = "1";
	$arr["Error"] = "";
}
else
{
	$arr["StatusID"] = "0";
	$arr["Error"] = "Error cannot upload file.";
}

echo json_encode($arr);
*/
                         

                     }
                     
                    // http://192.168.2.112/LRUDB/index.php/welcome/insert_data
                 public function  insert_data()
                 {
                     //echo  "test";
                     
                         $date1=$this->input->get_post("date1");  //วีัน
                         
                         if(strlen($date1) > 0  ) //23/12/2560  => 2017-12-29
                         {
                             $ex=explode("/",$date1);
                             
                             $Y_conv=  $ex[2] - 543;
                             $m=$ex[1];
                             $d=$ex[0];
                             $conv_date1=$Y_conv."-".$m."-".$d;  
                         }
                         else
                         {
                              $conv_date1="";
                         }
                         //$date1="14";
          
                         $hr=trim($this->input->get_post("hr"));
                         $min=trim($this->input->get_post("min"));
                         if( strlen($hr) > 0  && strlen($min) > 0   )
                         {
                             $time1=$hr.":".$min.":00";
                         }
                         else{
                             $time1= "00:00:00";  
                         }
                         
                     
                         $firstname=trim($this->input->get_post("firstname"));
                         
                         $tb_user="tb_user";
                         if( strlen($firstname) > 0  )
                         {
                             $query=$this->db->get_where($tb_user,array("firstname"=>$firstname));
                             $row=$query->row();
                             $id_user=$row->id_user;
                         }
                         
                         
                         $place=trim($this->input->get_post("place")); //สถานที่
                         
                         $position=trim($this->input->get_post("position")); //ตำแหน่ง
                         
                         
                         if(  strlen($position) > 0 )
                         {
                               $tb_position="tb_position";
                               $query=$this->db->get_where($tb_position,array("position"=>$position));
                               $row=$query->row();
                               $id_position=$row->id_position;
                               
                         }
                         
                         //$id_working
                         $working=trim($this->input->get_post("working"));
                         
                         $tb_working="tb_working";
                         if( strlen( $working ) > 0 )
                         {
                                $tb_working="tb_working";
                                $query=$this->db->get_where($tb_working,array("working"=>$working));
                                $row=$query->row();
                                $id_working=$row->id_working;
                                
                                
                         }
                         
                         $working_detail=trim($this->input->get_post("working_detail"));
                         
                         $header=trim($this->input->get_post("header"));
                         
                         if( strlen( $header) > 0  )
                         {
                             $tb_header="tb_header";
                             $query=$this->db->get_where( $tb_header ,array("header"=>$header));
                             $row=$query->row();
                             $id_header=$row->id_header;
                             
                         }
                         
                         
                         //tb_evaluation
                         
                         
                       $evaluation=trim($this->input->get_post("evaluation"));
                       if( strlen($evaluation) > 0  )
                       {
                            $tb_evaluation="tb_evaluation";
                            $query=$this->db->get_where($tb_evaluation,array("evaluation"=>$evaluation));
                            $row=$query->row();
                            $id_evaluation=$row->id_evaluation;
                            
                       }
                       
                       //   $file1name = $_FILES['filUpload']['name'];
                      $file1name = $_FILES['filUpload']['name'];
            	$file1tmp  =$_FILES['filUpload']["tmp_name"]; // tmp folder
           	$file1Type= $_FILES['filUpload']["type"]; //type of file
           	$file1Size= $_FILES['filUpload']["size"]; //size
           	$file1ErrorMsg = $_FILES['filUpload']["error"]; // 0=false 1=true
             	$cp1=copy($file1tmp ,  "uploadfile/". $file1name );
                
                

                                        $data=array(
                                 
                                 "date1"=>$conv_date1,
                                 "time1"=>$time1,           
                                 "id_user"=>$id_user,           
                                 "place"=>$place,
                                  "id_position"=>$id_position,
                                  "id_working"=>$id_working,          
                                  "working_detail"=>$working_detail,
                                  "id_header"=> $id_header,
                                  "id_evaluation"=>$id_evaluation,          
                                  "filenamePicture"=>$file1name,          
                                            
                                 );
                         

                         $tb="tb_main";
                         
                         //  echo     json_encode(array("date1"=> $conv_date1,"id_user"=>$id_user,"place"=>$place,"id_position"=>$id_position));
                 
                         
                         $ck=$this->db->insert($tb,$data);
                        if( $ck )
                         {
                               echo     json_encode(array("date1"=> $conv_date1,"id_user"=>$id_user,"place"=>$place,"id_position"=>$id_position,"working_detail"=>$working_detail,"id_header"=>$id_header,"hr"=>$hr,"time1"=>$time1));
                          }
                                              
                       //  elseif( !$ck )
                       //  {
                       //      echo json_encode(array("success"=>0));
                       //  }
          
                 }
        
}
