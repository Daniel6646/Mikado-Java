#include <stdio.h>      
void main()
{
int a[10][10],b[10][10],c[10][10];
int a1,b1,c1,d,p,q,k,i,j,sum=0;
printf("enter no of row&no of col of 1st matrix");
scanf("%d%d",&a1,&b1);
printf("enter no of row&no of col of 2nd matrix");
scanf("%d%d",&c1,&d);
if(b1!=c1)
	{
	printf("cant multiple");
	}
else
	{
		for(i=0;i<3;i++)
		{
			for(j=0;j<2;j++)
			{
				scanf("%d",&a[i][j]);
			}
		}
		for(i=0;i<2;i++)
		{
			for(j=0;j<3;j++)
			{
				scanf("%d",&b[i][j]);
			}
		}
	for(p=0;p<a1;p++)
		{
		for (q=0;q<d;q++)
		{
			for(k=0;k<c1;k++)
			{
				sum+=a[p][k]*b[k][q];
		}
			c[p][q]=sum;
			sum=0;
		}
	}
	for(p=0;p<a1;p++)
	{
		for(q=0;q<d;q++)
		{
			printf("%d ",c[p][q]);
		}
		printf("\n");
	}
	}
}

		