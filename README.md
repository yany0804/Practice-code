# Practice-code

### Intelligent Multi-terminal Snack Shopping Platform Based on Frontend + Layui + SpringBoot (Software Engineering Course Design)

The functions of this system can be divided into the following parts:


### User Management Module
#### User Login
Users enter their username and password. The system verifies if the user is an administrator. If the verification passes, the user is allowed to log in.


### Product Management Module
#### Product Addition
Enter the product name, select the product category, set the product status, fill in information such as the brand and product weight, upload the main product image, and save it to the database.

#### Product Modification
Locate the product based on the product ID, modify basic information, category, status, etc., perform operations such as putting the product on or off the shelves, and update the database.

#### Product Query
Support searching by product name, category, and status, and display the product list with pagination.

#### Product Deletion
Delete the product information based on the product ID and update the database.


### Category Management Module
#### Category Addition
Enter the category name and save it to the database.

#### Category Modification
Modify category data and update the database.

#### Category Query
Support fuzzy search by category name and display the category list with pagination.

#### Category Deletion
If there are no associated products under the category, the category information can be deleted based on the category ID and the database updated.


### Recommendation Management Module
#### Recommendation Addition
Select products and recommendation positions, add recommendation information while avoiding duplicate recommendations, and save it to the database.

#### Recommendation Modification
Modify recommendation information to avoid duplicate recommendations of the same product in the same position, and update the database.

#### Recommendation Query
Query recommendation information by recommendation position with pagination.

#### Recommendation Deletion
Delete recommendation information based on the recommendation ID and update the database.<br><br>

#### 基于前端+Layui+SpringBoot的智能多端零食购物平台（软件工程课程设计）
本系统的功能可以划分为如下几个部分：

1. 用户管理模块
    - 用户登录：用户输入用户名和密码，系统验证是否为管理员，验证通过则允许登录。

2. 商品管理模块
    - 商品添加：输入商品名、选择商品类别、设置商品状态、填写品牌、商品重量等信息，上传商品主图，保存至数据库。
    - 商品修改：根据商品ID定位商品，修改基本信息、类别、状态等，可进行上架与下架操作，更新数据库。
    - 商品查询：支持按商品名、类别、状态搜索，分页展示商品列表。
    - 商品删除：根据商品ID删除商品信息，更新数据库。

3. 类目管理模块
    - 类目添加：输入类目名称，保存至数据库。
    - 类目修改：修改类目数据，更新数据库。
    - 类目查询：支持按类目名称模糊查询，分页展示类目列表。
    - 类目删除：若类目下无关联商品，可根据类目ID删除类目信息并更新数据库。

4. 推荐管理模块
    - 推荐添加：选择商品和推荐位置，添加推荐信息，避免重复推荐，保存至数据库。
    - 推荐修改：修改推荐信息，避免同一商品在同一位置重复推荐，更新数据库。
    - 推荐查询：根据推荐位置分页查询推荐信息。
    - 推荐删除：根据推荐ID删除推荐信息并更新数据库。
