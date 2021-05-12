package com.kh.mybatis.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.common.AbstractController;
import com.kh.mybatis.emp.model.service.EmpService;
import com.kh.mybatis.emp.model.service.EmpServiceImpl;

public class UpdateEmpController extends AbstractController {
	
	private EmpService empService = new EmpServiceImpl();

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 사용자 입력값
		String empId = request.getParameter("empId");
		
		//2. 업무로직: 직급목록, 부서목록, 사원1명 정보(부서명, 직급명)
		List<Map<String, String>> jobList;
		jobList = empService.selectJobList();
		System.out.println("jobList@updatecontroller = " + jobList);
		
		List<Map<String, String>> deptList;
		deptList = empService.selectDeptList();
		System.out.println("deptList@updatecontroller = " + deptList);
		
		
		Map<String, Object> emp= empService.selectEmp(empId);
		
		
		
		//3.jsp 위임
		request.setAttribute("jobList", jobList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("emp", emp);
		
		
		return "emp/updateEmp";
	}

	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1. 사용자 입력값
		
		Map<String, String> map = new HashMap<>();
		
		String empId = request.getParameter("empId");
		map.put("empId", empId);
		
		String jobCode =null;
		if(request.getParameter("jobCode")!=null && !request.getParameter("jobCode").equals("")) {
			jobCode= request.getParameter("jobCode");
			map.put("jobCode", jobCode);
		}
		
		String deptCode =null;
		if(request.getParameter("deptCode")!=null && !request.getParameter("deptCode").equals("")) {
			deptCode= request.getParameter("deptCode");
			map.put("deptCode", deptCode);
		}
		
		//2. 업무로직: 수정
		
		int result = empService.updateEmp(map);
		System.out.println("result@updatecontroller = " + result);
		
		
		
		List<Map<String, String>> jobList;
		jobList = empService.selectJobList();
		System.out.println("jobList@updatecontroller = " + jobList);
		
		List<Map<String, String>> deptList;
		deptList = empService.selectDeptList();
		System.out.println("deptList@updatecontroller = " + deptList);
		
		Map<String, Object> emp= empService.selectEmp(empId);
		
		request.setAttribute("jobList", jobList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("emp", emp);
		
		return "redirect:/emp/updateEmp.do?empId=" + empId;
	}

}
