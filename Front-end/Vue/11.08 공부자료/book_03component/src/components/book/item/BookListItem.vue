<script setup>
defineProps({
  book: Object
})
</script>

<template>
  <tr class="text-center">
    <th>{{ book.isbn }}</th>
    <td>{{ book.title }}</td>
    <td>{{ book.author }}</td>
    <td>{{ book.price }}</td>
  </tr>
</template>

<style scoped></style>
