package com.oa.common;

import java.util.ArrayList;
import java.util.List;

import com.oa.filemailres.dto.Node;
import com.oa.filemailres.entity.FileVO;


public class TreeNodeUtils {

	public static List<Node> changeFileToNodes(List<FileVO> files) {
		
		List<Node> nodes = new ArrayList<Node>();
		if(files.size()==0){
			return nodes;
		}
		Node first = new Node();
		first.setId("0");
		first.setPid("-1");
		first.setName("--------文件-----");
		nodes.add(first);
		for (FileVO file : files) {
			Node node = new Node();
			node.setId(file.getId());
			/*node.setPid(file.getId() == null ? "0" : file.getFatherId()
					.toString());*/
			node.setName(file.getFileName());
			node.setTarget("main_right");
			node.setUrl("fileAction!files?fatherId=" +file.getFatherfile().getId());
			node.setPid(file.getFatherfile().getId());
			nodes.add(node);
		}

		return nodes;
	}


}
