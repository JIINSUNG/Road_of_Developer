<script setup>
defineProps({ currentPage: Number, startPage: Number, endPage: Number });

function range(start, end) {
  const list = [];
  for (let i = start; i <= end; i++) list.push(i);
  return list;
  //   return Array(end - start + 1)
  //     .fill()
  //     .map((val, i) => start + i);
}
</script>

<template>
  <div class="row">
    <ul class="pagination justify-content-center">
      <li class="page-item">
        <a class="page-link" href="#">이전</a>
      </li>
      <template v-for="pg in range(startPage, endPage)" :key="pg">
        <li class="page-item active" v-if="currentPage === pg">
          <a class="page-link" href="#">{{ pg }}</a>
        </li>
        <li class="page-item" v-else>
          <a class="page-link" href="#">{{ pg }}</a>
        </li>
      </template>
      <li class="page-item"><a class="page-link" href="#">다음</a></li>
    </ul>
  </div>
</template>

<style scoped></style>
