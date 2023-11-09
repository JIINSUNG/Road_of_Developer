<script setup>
defineProps({
  article: Object
})
</script>

<template>
  <tr class="text-center">
    <th>{{ article.articleNo }}</th>
    <td>{{ article.subject }}</td>
    <td>{{ article.userId }}</td>
    <td>{{ article.hit }}</td>
    <td>{{ article.registerDate }}</td>
  </tr>
</template>

<style scoped></style>
