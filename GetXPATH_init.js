/* Save this file content as a bookmark in Internet Explorer
This script helps to get the XPath of an element in IE-similar to Firefox's firebug/firepath
Select any element in a webpage and click on the two bookmarks GetXPATH_init.js,GetXPATH_final.js in the mentioned order to get the XPath of that element.
*/

javascript:function getNode(node)
{
var nodeExpr=node.tagName;
if(!nodeExpr)return null;
if(node.id!='')
{
nodeExpr+="[@id='"+node.id+"']";
return "/"+nodeExpr;
}
var rank=1;
var ps=node.previousSibling;
while(ps)
{
if(ps.tagName==node.tagName)
{
rank++;
}
ps=ps.previousSibling;
}
if(rank>1)
{
nodeExpr+='['+rank+']';
}
else
{
var ns=node.nextSibling;
while(ns)
{
if(ns.tagName==node.tagName)
{
nodeExpr+='[1]';
break;
}
ns=ns.nextSibling;
}
}
return nodeExpr;
}
