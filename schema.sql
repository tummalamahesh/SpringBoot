CREATE TABLE [dbo].[interest](
	id int IDENTITY(1,1) PRIMARY KEY,
	[address] [varchar](255) NULL,
	[amount] [float] NULL,
	[name] [varchar](255) NULL,
	[datetime] datetime,
	[status] bit,
	[rate] [float]
)
