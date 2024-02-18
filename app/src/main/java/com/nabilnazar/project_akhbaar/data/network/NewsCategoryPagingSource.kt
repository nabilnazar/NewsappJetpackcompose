package com.nabilnazar.project_akhbaar.data.network

//class NewsCategoryPagingSource(
//        private val newsApi: NewsApi,
//        private val category: List<String>
//):PagingSource<Int,CategoryNewsSource>() {
//
//        private var totalNewsCount = 0
//
//        override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int,CategoryNewsSource> {
//            val page = params.key ?: 1
//            return try {
//                val newsResponse = newsApi.getNewsByCategories(categories = category,)
//                totalNewsCount += newsResponse.articles.size
//                val articles = newsResponse.articles.distinctBy{ it.title } //Remove duplicates
//
//                PagingSource.LoadResult.Page(
//                    data = articles,
//                    nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
//                    prevKey = null
//                )
//            } catch (e: Exception) {
//                e.printStackTrace()
//                PagingSource.LoadResult.Error(
//                    throwable = e
//                )
//            }
//        }
//
//
//        override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
//            return state.anchorPosition?.let { anchorPosition ->
//                val anchorPage = state.closestPageToPosition(anchorPosition)
//                anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//            }
//        }
//
//    override fun getRefreshKey(state: PagingState<Int, CategoryNewsSource>): Int? {
//        TODO("Not yet implemented")
//    }
//}
