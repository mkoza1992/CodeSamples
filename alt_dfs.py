def alt_dfs(gr,start):
	n=gr[0]
	g=gr[1]
	vis=[]
	for i in n:
		vis.append(False)	
	stack=[]
	stack.append(start)
	while(len(stack)>0):
		k=stack.pop()
		if(vis[k]==False):
			vis[k]=True
			for i in g[k]:
				stack.append(i)
def count_components(gr):
        n=gr[0]        
        g=gr[1]
        l=n[len(n)-1]+1
        vis=[]
        num=0        
        for i in range(l):
                vis.append(False)
        for j in n:
                if(vis[j]==False):
                        num+=1
                        alt_dfs(g,j,vis)
        return num


f=open("g4.txt","r")
s=f.read()
exec(s)
print(count_components(g4))
